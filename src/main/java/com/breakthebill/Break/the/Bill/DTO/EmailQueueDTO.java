package com.breakthebill.Break.the.Bill.DTO;

import lombok.Data;

@Data
public class EmailQueueDTO {
    private String toEmail;
    private String subject;
    private String body;
}
