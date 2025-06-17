package com.breakthebill.Break.the.Bill.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "notifications")
@Data
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String message;

    @Column(length = 255)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationType type;

    @Column(nullable = false)
    private Boolean read;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    public enum NotificationType {
        EXPENSE_ADDED,
        SETTLED,
        GROUP_UPDATE
    }
}
