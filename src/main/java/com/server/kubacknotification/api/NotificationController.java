package com.server.kubacknotification.api;

import com.server.kubacknotification.application.dto.request.CreateTicketOpenRequest;
import com.server.kubacknotification.application.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping("/api/notifications")
    public void createTicketOpenNotifications(@RequestBody CreateTicketOpenRequest createTicketOpenRequest) {
        notificationService.createTicketOpenNotification(createTicketOpenRequest);
    }
}
