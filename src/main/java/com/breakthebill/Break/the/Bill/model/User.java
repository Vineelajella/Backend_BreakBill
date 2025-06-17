package com.breakthebill.Break.the.Bill.model;

import java.sql.Timestamp;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private Boolean isDeleted = false;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;
}
