package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.CategoryDTO;
import com.breakthebill.Break.the.Bill.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category createCategory(CategoryDTO dto);
    Optional<Category> getCategoryById(Long id);
    List<Category> getAllCategories();
}
