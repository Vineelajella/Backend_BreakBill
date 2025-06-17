package com.breakthebill.Break.the.Bill.DTO;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class ReceiptDTO {
    private Long expenseId;
    private String imageUrl;
    private byte[] imageData;
    private Timestamp createdAt;
}

