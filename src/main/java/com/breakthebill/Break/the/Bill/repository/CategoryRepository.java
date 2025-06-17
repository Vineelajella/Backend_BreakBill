package com.breakthebill.Break.the.Bill.repository;

import com.breakthebill.Break.the.Bill.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
