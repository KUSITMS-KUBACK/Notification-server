package com.server.kubacknotification.application.service;

import com.server.kubacknotification.application.dto.request.TicketOpenMessage;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.context.Context;

import static org.mockito.Mockito.*;

class EmailServiceTest {

    @Mock
    private JavaMailSender javaMailSender;

    @Mock
    private SpringTemplateEngine templateEngine;

    @InjectMocks
    private EmailService emailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // 이 줄을 추가하여 목 객체를 초기화합니다.
    }

    @Test
    void testConsumeNoticeMessage() {
        // given
        TicketOpenMessage ticketOpenMessage = new TicketOpenMessage("뮤지컬 킹키부츠", "2024.10.10.(목) 14:00에 티켓이 오픈됩니다!", "somin455@gmail.com", 1L, "윤소민");

        // when
        emailService.consumeNoticeMessage(ticketOpenMessage);

        // then
        // 이메일 발송 메서드가 호출되었는지 확인
        verify(javaMailSender, times(1)).createMimeMessage();
    }

    @Test
    void testSendTicketOpenEmail() throws Exception {
        // given
        TicketOpenMessage ticketOpenMessage = new TicketOpenMessage("뮤지컬 킹키부츠", "2024.10.10.(목) 14:00에 티켓이 오픈됩니다!", "somin455@gmail.com", 1L, "윤소민");

        MimeMessage mimeMessage = mock(MimeMessage.class);
        when(javaMailSender.createMimeMessage()).thenReturn(mimeMessage);

        // HTML 템플릿 처리 결과를 설정
        when(templateEngine.process(anyString(), any(Context.class))).thenReturn("<html>Test</html>");

        // when
        emailService.sendTicketOpenEmail(ticketOpenMessage);

        // then
        // 이메일 전송이 수행되었는지 검증
        verify(javaMailSender, times(1)).send(mimeMessage);
    }

    @Test
    void testSetTicketOpenContext() {
        // given
        TicketOpenMessage ticketOpenMessage = new TicketOpenMessage("뮤지컬 킹키부츠", "2024.10.10.(목) 14:00에 티켓이 오픈됩니다!", "somin455@gmail.com", 1L, "윤소민");

        // when
        String htmlContent = emailService.setTicketOpenContext(ticketOpenMessage);

        // then
        // HTML 템플릿 생성 확인
        verify(templateEngine, times(1)).process("ticketOpen", any(Context.class));
    }
}
