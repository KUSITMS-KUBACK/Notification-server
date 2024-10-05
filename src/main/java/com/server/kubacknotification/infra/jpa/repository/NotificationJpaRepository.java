package com.server.kubacknotification.infra.jpa.repository;


import com.server.kubacknotification.domain.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationJpaRepository extends JpaRepository<Notification, Long> {
}
