package com.server.kubacknotification.application.service;

import com.server.kubacknotification.application.dto.request.TicketOpenMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotificationService {
    private final KafkaTemplate<String, TicketOpenMessage> kafkaTemplate;
    private static final String TOPIC = "ticketOpen";

    public void createTicketOpenNotification(TicketOpenMessage ticketOpenMessage) {
        kafkaTemplate.send(TOPIC, ticketOpenMessage);
    }
}