package com.server.kubacknotification.infra.jpa.repository;

import com.server.kubacknotification.infra.jpa.entity.AEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AJpaRepository extends JpaRepository<AEntity, Long> {
}
