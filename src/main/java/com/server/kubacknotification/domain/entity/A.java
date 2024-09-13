package com.server.kubacknotification.domain.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class A {
    private Long id;
    private String name;

    public static A toDomain(
            Long id,
            String name) {
        return new A(id, name);
    }
}
