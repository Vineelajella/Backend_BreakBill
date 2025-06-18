package com.breakthebill.Break.the.Bill.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String email;
    private String password;
    private String confirmPassword;

    // Getters and setters
}