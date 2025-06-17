package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.CategoryDTO;
import com.breakthebill.Break.the.Bill.model.Category;
import com.breakthebill.Break.the.Bill.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(CategoryDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category.setCreatedBy(dto.getCreatedBy());
        category.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        category.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
