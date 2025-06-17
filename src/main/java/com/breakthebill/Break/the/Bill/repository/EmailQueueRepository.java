package com.breakthebill.Break.the.Bill.repository;

import com.breakthebill.Break.the.Bill.model.EmailQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailQueueRepository extends JpaRepository<EmailQueue, Long> {
}
