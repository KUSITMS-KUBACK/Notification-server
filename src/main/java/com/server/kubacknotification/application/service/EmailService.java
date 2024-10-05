package com.server.kubacknotification.application.service;

import com.server.kubacknotification.global.common.PaymentMessage;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class EmailService {

	private final JavaMailSender javaMailSender;
	private final SpringTemplateEngine templateEngine;

	// Kafka로부터 PaymentMessage를 수신하고 이메일 발송
	@KafkaListener(topics = "payment", groupId = "group1", containerFactory = "paymentMessageKafkaListenerContainerFactory")
	public void consumePaymentMessage(PaymentMessage paymentMessage) {
		sendPaymentEmail(paymentMessage);
	}

	@Async
	public void sendPaymentEmail(PaymentMessage paymentMessage) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
			mimeMessageHelper.setTo(paymentMessage.getEmail()); // 수신자 이메일을 PaymentMessage의 email 필드로 설정
			mimeMessageHelper.setSubject("결제 완료 안내"); // 이메일 제목

			// HTML 콘텐츠 생성
			String htmlContent = setPaymentContext(paymentMessage);
			mimeMessageHelper.setText(htmlContent, true); // HTML 여부 true 설정

			javaMailSender.send(mimeMessage);
			log.info("Succeeded to send Email to: {}", paymentMessage.getUserId());
		} catch (Exception e) {
			log.error("Failed to send Email to: {}", paymentMessage.getUserId(), e);
			throw new RuntimeException(e);
		}
	}

	// HTML 템플릿에 PaymentMessage 데이터 주입
	public String setPaymentContext(PaymentMessage paymentMessage) {
		Context context = new Context();
		context.setVariable("paymentMessage", paymentMessage);
		return templateEngine.process("payment", context); // "payment.html" 템플릿 사용
	}
}
