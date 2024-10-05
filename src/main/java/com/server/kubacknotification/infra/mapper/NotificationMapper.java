package com.server.kubacknotification.infra.mapper;

import com.server.kubacknotification.domain.entity.Notification;
import com.server.kubacknotification.infra.jpa.entity.NotificationEntity;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {
    public Notification toDomain(Notification notification) {
        return Notification.toDomain(
                notification.getId(),
                notification.getUserId(),
                notification.getTitle(),
                notification.getContent()
        );
    }
    public NotificationEntity toEntity(Notification notification) {
        return NotificationEntity.toEntity(
                notification.getId(),
                notification.getUserId(),
                notification.getTitle(),
                notification.getContent());
    }
}
