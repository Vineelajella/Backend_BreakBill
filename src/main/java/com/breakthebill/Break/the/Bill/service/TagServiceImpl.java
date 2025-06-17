package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.TagDTO;
import com.breakthebill.Break.the.Bill.model.Expense;
import com.breakthebill.Break.the.Bill.model.Tag;
import com.breakthebill.Break.the.Bill.repository.ExpenseRepository;
import com.breakthebill.Break.the.Bill.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final ExpenseRepository expenseRepository;

    public TagServiceImpl(TagRepository tagRepository, ExpenseRepository expenseRepository) {
        this.tagRepository = tagRepository;
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Tag createTag(TagDTO tagDTO) {
        Tag tag = new Tag();
        tag.setName(tagDTO.getName());
        tag.setCreatedBy(tagDTO.getCreatedBy());
        tag.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public void assignTagToExpense(Long tagId, Long expenseId) {
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new RuntimeException("Tag not found"));
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        expense.getTags().add(tag);
        expenseRepository.save(expense);
    }
}
