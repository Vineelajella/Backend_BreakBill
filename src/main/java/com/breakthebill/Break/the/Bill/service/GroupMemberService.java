package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.GroupMemberDTO;
import com.breakthebill.Break.the.Bill.model.GroupMember;

import java.util.List;
import java.util.Optional;

public interface GroupMemberService {
    GroupMember addMember(GroupMemberDTO dto);
    Optional<GroupMember> getById(Long id);
    List<GroupMember> getByGroup(Long groupId);
}
