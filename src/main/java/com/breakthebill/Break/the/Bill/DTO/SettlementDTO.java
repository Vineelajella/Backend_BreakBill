package com.breakthebill.Break.the.Bill.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SettlementDTO {
    private Long groupId;
    private Long payerId;
    private Long receiverId;
    private BigDecimal amount;
    private Boolean isPartial;
    private String via;
}
