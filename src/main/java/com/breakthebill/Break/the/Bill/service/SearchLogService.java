package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.SearchLogDTO;
import com.breakthebill.Break.the.Bill.model.SearchLog;

import java.util.List;

public interface SearchLogService {
    SearchLog createSearchLog(SearchLogDTO dto);
    List<SearchLog> getAllLogs();
    List<SearchLog> getLogsByUserId(Long userId);
}
