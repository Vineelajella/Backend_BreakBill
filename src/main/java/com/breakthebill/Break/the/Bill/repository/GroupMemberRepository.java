package com.breakthebill.Break.the.Bill.repository;

import com.breakthebill.Break.the.Bill.model.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {
    List<GroupMember> findByGroupId(Long groupId);
    long countByGroupIdAndRole(Long groupId, GroupMember.Role role);
}
