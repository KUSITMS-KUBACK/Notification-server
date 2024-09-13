package com.server.kubacknotification.infra.mapper;

import com.server.kubacknotification.domain.entity.A;
import com.server.kubacknotification.infra.jpa.entity.AEntity;
import org.springframework.stereotype.Component;

@Component
public class AMapper {
    public A toDomain(AEntity aEntity) {
        return A.toDomain(
                aEntity.getId(),
                aEntity.getName()
        );
    }
    public AEntity toEntity(A a) {
        return AEntity.toEntity(
                a.getId(),
                a.getName()
        );
    }
}
