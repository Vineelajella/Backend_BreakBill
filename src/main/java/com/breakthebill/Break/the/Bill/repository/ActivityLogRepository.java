package com.breakthebill.Break.the.Bill.repository;

import com.breakthebill.Break.the.Bill.model.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
}
