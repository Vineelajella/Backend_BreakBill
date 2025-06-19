package com.breakthebill.Break.the.Bill.controller;

import com.breakthebill.Break.the.Bill.DTO.LoginDTO;
import com.breakthebill.Break.the.Bill.DTO.UserDTO;
import com.breakthebill.Break.the.Bill.model.User;
import com.breakthebill.Break.the.Bill.service.UserService;

import org.springframework.http.HttpStatus;
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

    // 🔹 Register user with duplicate check
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody UserDTO userDTO) {
        Map<String, String> response = new HashMap<>();

        try {
            if (userService.emailExists(userDTO.getEmail())) {
                response.put("error", "❌ Email already registered");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(response); // 409 Conflict
            }

            userService.createUser(userDTO);
            response.put("message", "✅ User registered successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "❌ Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
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

    // 🔹 Login and store user login info
    @PostMapping("/login")
    public ResponseEntity<?> loginAndStore(@RequestBody LoginDTO loginDTO) {
        try {
            userService.saveLoginInfo(loginDTO);
            Map<String, String> response = new HashMap<>();
            response.put("message", "✅ Login data stored successfully");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "❌ " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }
}
