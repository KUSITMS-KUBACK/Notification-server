package com.server.kubacknotification.domain.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Notification {
    private Long id;
    private Long userId;
    private String title;
    private String content;

    public static Notification toDomain(
            Long id,
            Long userId,
            String title,
            String content) {
        return new Notification(id, userId, title, content);
    }
}
