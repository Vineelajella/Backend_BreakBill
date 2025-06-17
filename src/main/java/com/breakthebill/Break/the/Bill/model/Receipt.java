package com.breakthebill.Break.the.Bill.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "receipts")
@Data
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "expense_id", unique = true)
    private Long expenseId;

    private String imageUrl;

    @Lob
    private byte[] imageData;

    private Timestamp createdAt;
}
