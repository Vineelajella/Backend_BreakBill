package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.UserDTO;
import com.breakthebill.Break.the.Bill.model.User;

import java.util.Optional;

public interface UserService {
    User createUser(UserDTO userDTO);
    Optional<User> getUserById(Long id); // ⬅️ Long instead of UUID
}
