package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.SettlementDTO;
import com.breakthebill.Break.the.Bill.model.Settlement;

import java.util.List;
import java.util.Optional;

public interface SettlementService {
    Settlement createSettlement(SettlementDTO dto);
    Optional<Settlement> getById(Long id);
    List<Settlement> getAll();
}
