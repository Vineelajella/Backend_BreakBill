package com.breakthebill.Break.the.Bill.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "search_logs")
@Data
public class SearchLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String query;

    @Column(name = "searched_at")
    private Timestamp searchedAt;
}
