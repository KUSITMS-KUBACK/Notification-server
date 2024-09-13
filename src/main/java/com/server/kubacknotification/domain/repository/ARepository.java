package com.server.kubacknotification.domain.repository;

import com.server.kubacknotification.domain.entity.A;
import org.springframework.stereotype.Repository;

@Repository
public interface ARepository {
    A findById(Long id);
}
