package com.server.kubacknotification.application.service;

import com.server.kubacknotification.global.common.PaymentMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

	private final KafkaTemplate<String, PaymentMessage> kafkaTemplate;
	private static final String TOPIC = "payment";

	public void publishPaymentMessage(PaymentMessage paymentMessage) {
		// Kafka로 paymentMessage 전송
		kafkaTemplate.send(TOPIC, paymentMessage);
	}
}
