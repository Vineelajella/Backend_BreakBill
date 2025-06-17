package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.SearchLogDTO;
import com.breakthebill.Break.the.Bill.model.SearchLog;
import com.breakthebill.Break.the.Bill.repository.SearchLogRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class SearchLogServiceImpl implements SearchLogService {

    private final SearchLogRepository searchLogRepository;

    public SearchLogServiceImpl(SearchLogRepository searchLogRepository) {
        this.searchLogRepository = searchLogRepository;
    }

    @Override
    public SearchLog createSearchLog(SearchLogDTO dto) {
        SearchLog log = new SearchLog();
        log.setUserId(dto.getUserId());
        log.setQuery(dto.getQuery());
        log.setSearchedAt(new Timestamp(System.currentTimeMillis()));
        return searchLogRepository.save(log);
    }

    @Override
    public List<SearchLog> getAllLogs() {
        return searchLogRepository.findAll();
    }

    @Override
    public List<SearchLog> getLogsByUserId(Long userId) {
        return searchLogRepository.findAll()
                .stream()
                .filter(log -> log.getUserId().equals(userId))
                .toList();
    }
}
