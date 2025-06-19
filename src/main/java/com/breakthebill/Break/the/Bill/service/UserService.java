package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.LoginDTO;
import com.breakthebill.Break.the.Bill.DTO.UserDTO;
import com.breakthebill.Break.the.Bill.model.User;

import java.util.Optional;

import java.util.List;

public interface UserService {
    User createUser(UserDTO userDTO);
    Optional<User> getUserById(Long id);
    List<User> getAllUsers(); // 👈 Add this
    void saveLoginInfo(LoginDTO loginDTO);
	boolean emailExists(String email);
    
}
