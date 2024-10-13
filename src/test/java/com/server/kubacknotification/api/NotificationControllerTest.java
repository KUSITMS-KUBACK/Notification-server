package com.server.kubacknotification.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.kubacknotification.application.dto.request.TicketOpenMessage;
import com.server.kubacknotification.application.service.NotificationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NotificationController.class)
public class NotificationControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("티켓팅 홍보 알림 테스트")
    void createTicketOpenNotifications() throws Exception {
        //given
        TicketOpenMessage ticketOpenMessage = new TicketOpenMessage(
                "뮤지컬 킹키부츠 티켓 오픈",
                "뮤지컬 킹키부츠 2024.10.10.(목) 14:00에 티켓이 오픈됩니다!",
                "somin455@gmail.com",
                1L,
                "윤소민"
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(ticketOpenMessage);

        //when
        mvc.perform(post("/api/notifications/ticket-open")
                .contentType("application/json")
                .content(requestJson))
                //then
                .andExpect(status().isOk());
    }
}
