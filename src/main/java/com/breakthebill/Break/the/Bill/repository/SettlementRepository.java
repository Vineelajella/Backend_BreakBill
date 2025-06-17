package com.breakthebill.Break.the.Bill.repository;

import com.breakthebill.Break.the.Bill.model.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementRepository extends JpaRepository<Settlement, Long> {
}
