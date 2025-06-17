package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.ExpenseParticipantDTO;
import com.breakthebill.Break.the.Bill.model.ExpenseParticipant;
import com.breakthebill.Break.the.Bill.repository.ExpenseParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseParticipantServiceImpl implements ExpenseParticipantService {

    private final ExpenseParticipantRepository repository;

    public ExpenseParticipantServiceImpl(ExpenseParticipantRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExpenseParticipant createExpenseParticipant(ExpenseParticipantDTO dto) {
        ExpenseParticipant participant = new ExpenseParticipant();
        participant.setExpenseId(dto.getExpenseId());
        participant.setUserId(dto.getUserId());
        participant.setShareAmount(dto.getShareAmount());
        participant.setBonusAmount(dto.getBonusAmount());
        participant.setExcluded(dto.getExcluded());
        return repository.save(participant);
    }

    @Override
    public Optional<ExpenseParticipant> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<ExpenseParticipant> getAll() {
        return repository.findAll();
    }
}
