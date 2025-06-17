package com.breakthebill.Break.the.Bill.DTO;

import lombok.Data;

@Data
public class CategoryDTO {
    private String name;
    private Long createdBy; // Can be null if optional
}
