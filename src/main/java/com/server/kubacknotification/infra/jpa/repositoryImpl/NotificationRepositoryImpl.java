package com.server.kubacknotification.infra.jpa.repositoryImpl;

import com.server.kubacknotification.domain.entity.Notification;
import com.server.kubacknotification.domain.repository.NotificationRepository;
import com.server.kubacknotification.infra.jpa.repository.NotificationJpaRepository;
import com.server.kubacknotification.infra.mapper.NotificationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class NotificationRepositoryImpl implements NotificationRepository {
    private final NotificationJpaRepository notificationJpaRepository;
    private final NotificationMapper notificationMapper;


    @Override
    public Notification findById(Long id) {
        return notificationMapper.toDomain(notificationJpaRepository.findById(id).orElseThrow());
    }
}
