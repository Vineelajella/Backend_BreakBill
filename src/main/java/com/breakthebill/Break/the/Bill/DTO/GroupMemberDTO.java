package com.breakthebill.Break.the.Bill.DTO;

import lombok.Data;

@Data
public class GroupMemberDTO {
    private Long userId;
    private Long groupId;
    private String role; // "owner" or "member"
}
