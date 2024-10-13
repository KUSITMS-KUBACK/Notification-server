package com.server.kubacknotification.domain.repository;

import com.server.kubacknotification.domain.entity.Notification;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository {
    Notification findById(Long id);
}
