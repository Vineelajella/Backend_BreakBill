package com.breakthebill.Break.the.Bill.DTO;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class GroupOwnershipTransferDTO {
    private Long groupId;
    private Long fromUserId;
    private Long toUserId;
    private Timestamp transferredAt;
}
