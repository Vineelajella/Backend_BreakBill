package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.GroupMemberDTO;
import com.breakthebill.Break.the.Bill.model.GroupMember;
import com.breakthebill.Break.the.Bill.model.GroupMember.Role;
import com.breakthebill.Break.the.Bill.repository.GroupMemberRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class GroupMemberServiceImpl implements GroupMemberService {

    private final GroupMemberRepository groupMemberRepository;

    public GroupMemberServiceImpl(GroupMemberRepository groupMemberRepository) {
        this.groupMemberRepository = groupMemberRepository;
    }

    @Override
    public GroupMember addMember(GroupMemberDTO dto) {
        // Enforce only one owner per group
        if ("owner".equalsIgnoreCase(dto.getRole())) {
            long ownerCount = groupMemberRepository.countByGroupIdAndRole(dto.getGroupId(), Role.owner);
            if (ownerCount > 0) {
                throw new IllegalStateException("Only one owner allowed per group.");
            }
        }

        GroupMember member = new GroupMember();
        member.setUserId(dto.getUserId());
        member.setGroupId(dto.getGroupId());
        member.setRole(Role.valueOf(dto.getRole().toLowerCase()));
        member.setJoinedAt(new Timestamp(System.currentTimeMillis()));
        member.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        member.setIsDeleted(false);

        return groupMemberRepository.save(member);
    }

    @Override
    public Optional<GroupMember> getById(Long id) {
        return groupMemberRepository.findById(id);
    }

    @Override
    public List<GroupMember> getByGroup(Long groupId) {
        return groupMemberRepository.findByGroupId(groupId);
    }
}
