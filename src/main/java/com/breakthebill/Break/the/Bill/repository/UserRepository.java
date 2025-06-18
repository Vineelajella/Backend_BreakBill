package com.breakthebill.Break.the.Bill.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.breakthebill.Break.the.Bill.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { // ⬅️ Long instead of UUID
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email); 
}
