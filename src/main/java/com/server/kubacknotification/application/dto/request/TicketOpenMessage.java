package com.server.kubacknotification.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketOpenMessage {
    private String title; // 공연 제목
    private String description; // 공연 설명
    private String email;
    private Long userId;
    private String userName;
}