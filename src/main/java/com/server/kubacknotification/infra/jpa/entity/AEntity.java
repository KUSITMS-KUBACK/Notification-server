package com.server.kubacknotification.infra.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;

    public static AEntity toEntity(
            Long id,
            String name
    ) {
        return new AEntity(id, name);
    }
}
