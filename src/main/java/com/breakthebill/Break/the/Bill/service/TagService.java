package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.TagDTO;
import com.breakthebill.Break.the.Bill.model.Tag;

import java.util.List;

public interface TagService {
    Tag createTag(TagDTO tagDTO);
    List<Tag> getAllTags();
    void assignTagToExpense(Long tagId, Long expenseId);
}
