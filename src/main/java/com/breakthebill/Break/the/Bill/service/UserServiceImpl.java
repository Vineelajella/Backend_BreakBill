package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.LoginDTO;
import com.breakthebill.Break.the.Bill.DTO.UserDTO;
import com.breakthebill.Break.the.Bill.model.User;
import com.breakthebill.Break.the.Bill.repository.UserRepository;
import com.breakthebill.Break.the.Bill.service.UserService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());

        // Optional: hash password if storing securely
        user.setPasswordHash(userDTO.getPassword());

        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User saveLoginInfo(LoginDTO loginDTO) {
        User user = new User();
        user.setEmail(loginDTO.getEmail());
        user.setPasswordHash(loginDTO.getPassword());

        return userRepo.save(user);
    }
}
