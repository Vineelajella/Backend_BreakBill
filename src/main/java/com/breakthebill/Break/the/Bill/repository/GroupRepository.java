package com.breakthebill.Break.the.Bill.repository;

import com.breakthebill.Break.the.Bill.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
