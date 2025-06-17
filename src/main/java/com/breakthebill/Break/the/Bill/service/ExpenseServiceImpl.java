package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.ExpenseDTO;
import com.breakthebill.Break.the.Bill.model.Expense;
import com.breakthebill.Break.the.Bill.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Expense createExpense(ExpenseDTO dto) {
        Expense expense = new Expense();
        expense.setGroupId(dto.getGroupId());
        expense.setTitle(dto.getTitle());
        expense.setAmount(dto.getAmount());
        expense.setPaidBy(dto.getPaidBy());
        expense.setDate(dto.getDate());
        expense.setDescription(dto.getDescription());
        expense.setCategoryId(dto.getCategoryId());
        expense.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        expense.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        expense.setIsDeleted(false);
        return expenseRepository.save(expense);
    }

    @Override
    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
}
