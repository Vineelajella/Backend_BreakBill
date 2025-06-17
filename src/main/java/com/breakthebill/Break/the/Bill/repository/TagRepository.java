package com.breakthebill.Break.the.Bill.repository;

import com.breakthebill.Break.the.Bill.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
