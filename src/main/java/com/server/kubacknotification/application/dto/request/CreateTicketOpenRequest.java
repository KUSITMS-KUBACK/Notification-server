package com.server.kubacknotification.application.dto.request;

public record CreateTicketOpenRequest (
        String title,
        String description
){
}