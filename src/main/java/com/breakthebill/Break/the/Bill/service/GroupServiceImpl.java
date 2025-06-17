package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.GroupDTO;
import com.breakthebill.Break.the.Bill.model.Group;
import com.breakthebill.Break.the.Bill.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group createGroup(GroupDTO groupDTO) {
        Group group = new Group();
        group.setName(groupDTO.getName());
        group.setInviteCode(generateInviteCode());
        group.setCreatedBy(groupDTO.getCreatedBy());
        group.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        group.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        group.setIsDeleted(false); 
        return groupRepository.save(group);
    }

    @Override
    public Optional<Group> getGroupById(Long id) {
        return groupRepository.findById(id);
    }

    private String generateInviteCode() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
