package com.breakthebill.Break.the.Bill.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "expense_participants")
@Data
public class ExpenseParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "expense_id")
    private Long expenseId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "share_amount", nullable = false)
    private BigDecimal shareAmount;

    @Column(name = "bonus_amount")
    private BigDecimal bonusAmount;

    @Column(name = "excluded")
    private Boolean excluded;
}
