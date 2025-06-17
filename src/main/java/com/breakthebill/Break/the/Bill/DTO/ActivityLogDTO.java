package com.breakthebill.Break.the.Bill.DTO;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ActivityLogDTO {
    private Long userId;
    private Long groupId;
    private String actionType;
    private String description;
    private String details;
    private Timestamp timestamp;
}
