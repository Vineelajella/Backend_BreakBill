package com.breakthebill.Break.the.Bill.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "settlements")
@Data
public class Settlement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_id", nullable = false)
    private Long groupId;

    @Column(name = "payer_id", nullable = false)
    private Long payerId;

    @Column(name = "receiver_id", nullable = false)
    private Long receiverId;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(name = "is_partial", nullable = false)
    private Boolean isPartial;

    @Column(name = "via", nullable = false)
    private String via; // Manual / Razorpay

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
