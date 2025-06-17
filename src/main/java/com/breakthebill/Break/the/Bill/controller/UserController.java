package com.breakthebill.Break.the.Bill.controller;

import com.breakthebill.Break.the.Bill.DTO.LoginDTO;
import com.breakthebill.Break.the.Bill.DTO.UserDTO;
import com.breakthebill.Break.the.Bill.model.User;
import com.breakthebill.Break.the.Bill.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 🔹 Register user
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);

        Map<String, String> response = new HashMap<>();
        response.put("message", "✅ User registered successfully");
        return ResponseEntity.ok(response);
    }

    // 🔹 Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 Get all users
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // 🔹 Login and store user
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginAndStore(@RequestBody LoginDTO loginDTO) {
        userService.saveLoginInfo(loginDTO);

        Map<String, String> response = new HashMap<>();
        response.put("message", "✅ Login data stored successfully");
        return ResponseEntity.ok(response);
    }
}
