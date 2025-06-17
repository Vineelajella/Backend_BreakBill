package com.breakthebill.Break.the.Bill.controller;

import com.breakthebill.Break.the.Bill.DTO.SearchLogDTO;
import com.breakthebill.Break.the.Bill.model.SearchLog;
import com.breakthebill.Break.the.Bill.service.SearchLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search-logs")
public class SearchLogController {

    private final SearchLogService searchLogService;

    public SearchLogController(SearchLogService searchLogService) {
        this.searchLogService = searchLogService;
    }

    @PostMapping
    public SearchLog createLog(@RequestBody SearchLogDTO dto) {
        return searchLogService.createSearchLog(dto);
    }

    @GetMapping
    public List<SearchLog> getAllLogs() {
        return searchLogService.getAllLogs();
    }

    @GetMapping("/user/{userId}")
    public List<SearchLog> getLogsByUser(@PathVariable Long userId) {
        return searchLogService.getLogsByUserId(userId);
    }
}
