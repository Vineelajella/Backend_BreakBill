package com.breakthebill.Break.the.Bill.repository;

import com.breakthebill.Break.the.Bill.model.SearchLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchLogRepository extends JpaRepository<SearchLog, Long> {
}
