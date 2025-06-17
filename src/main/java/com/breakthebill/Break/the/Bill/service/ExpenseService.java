package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.ExpenseDTO;
import com.breakthebill.Break.the.Bill.model.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {
    Expense createExpense(ExpenseDTO dto);
    Optional<Expense> getExpenseById(Long id);
    List<Expense> getAllExpenses();
}
