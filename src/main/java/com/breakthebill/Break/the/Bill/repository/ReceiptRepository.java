package com.breakthebill.Break.the.Bill.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.breakthebill.Break.the.Bill.model.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}