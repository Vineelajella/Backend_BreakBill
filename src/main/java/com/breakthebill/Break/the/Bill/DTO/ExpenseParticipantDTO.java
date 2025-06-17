package com.breakthebill.Break.the.Bill.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExpenseParticipantDTO {
    private Long expenseId;
    private Long userId;
    private BigDecimal shareAmount;
    private BigDecimal bonusAmount;
    private Boolean excluded;
}
