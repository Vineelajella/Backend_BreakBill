package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.ExpenseParticipantDTO;
import com.breakthebill.Break.the.Bill.model.ExpenseParticipant;

import java.util.List;
import java.util.Optional;

public interface ExpenseParticipantService {
    ExpenseParticipant createExpenseParticipant(ExpenseParticipantDTO dto);
    Optional<ExpenseParticipant> getById(Long id);
    List<ExpenseParticipant> getAll();
}
