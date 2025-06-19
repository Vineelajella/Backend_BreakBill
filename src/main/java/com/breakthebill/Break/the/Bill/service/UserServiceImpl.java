package com.breakthebill.Break.the.Bill.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.breakthebill.Break.the.Bill.DTO.LoginDTO;
import com.breakthebill.Break.the.Bill.DTO.UserDTO;
import com.breakthebill.Break.the.Bill.model.User;
import com.breakthebill.Break.the.Bill.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
        this.passwordEncoder = new BCryptPasswordEncoder(); // ✅ initialize encoder once
    }

    @Override
    public User createUser(UserDTO userDTO) {
        // 1. Validate passwords match
        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            throw new IllegalArgumentException("❌ Passwords do not match.");
        }

        // 2. Check if email already exists
        if (userRepo.existsByEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("❌ Email already registered.");
        }

        // 3. Create and save user
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPasswordHash(passwordEncoder.encode(userDTO.getPassword()));
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        user.setIsDeleted(false);

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
    public void saveLoginInfo(LoginDTO loginDTO) {
        Optional<User> userOpt = userRepo.findByEmail(loginDTO.getEmail());

        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = userOpt.get();

        // ✅ Compare hashed password
        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid password");
        }

        // Optionally update last login time or log login
        user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        userRepo.save(user);
    }

    @Override
    public boolean emailExists(String email) {
        return userRepo.existsByEmail(email);
    }
}
