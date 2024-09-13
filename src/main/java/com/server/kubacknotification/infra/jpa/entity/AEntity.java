package com.server.kubacknotification.infra.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class AEntity {
    @Id
    @GeneratedValue
    private Long id;
}
