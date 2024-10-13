package com.server.kubacknotification.infra.jpa.repository;


import com.server.kubacknotification.infra.jpa.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationJpaRepository extends JpaRepository<NotificationEntity, Long> {
}
