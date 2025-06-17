package com.breakthebill.Break.the.Bill.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class ExpenseDTO {
    private Long groupId;
    private String title;
    private BigDecimal amount;
    private Long paidBy;
    private Date date;
    private String description;
    private Long categoryId;
}
