package com.breakthebill.Break.the.Bill.model;

import java.sql.Timestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "groups")
@Data
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment for Long
    private Long id;

    private String name;

    @Column(unique = true)
    private String inviteCode;

    @Column(name = "created_by")
    private Long createdBy; // Already Long ✅

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private Boolean isDeleted = false;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;
}
