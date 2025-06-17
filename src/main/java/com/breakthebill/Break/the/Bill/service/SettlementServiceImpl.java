package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.SettlementDTO;
import com.breakthebill.Break.the.Bill.model.Settlement;
import com.breakthebill.Break.the.Bill.repository.SettlementRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class SettlementServiceImpl implements SettlementService {

    private final SettlementRepository repository;

    public SettlementServiceImpl(SettlementRepository repository) {
        this.repository = repository;
    }

    @Override
    public Settlement createSettlement(SettlementDTO dto) {
        Settlement settlement = new Settlement();
        settlement.setGroupId(dto.getGroupId());
        settlement.setPayerId(dto.getPayerId());
        settlement.setReceiverId(dto.getReceiverId());
        settlement.setAmount(dto.getAmount());
        settlement.setIsPartial(dto.getIsPartial());
        settlement.setVia(dto.getVia());
        settlement.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        settlement.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return repository.save(settlement);
    }

    @Override
    public Optional<Settlement> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Settlement> getAll() {
        return repository.findAll();
    }
}
