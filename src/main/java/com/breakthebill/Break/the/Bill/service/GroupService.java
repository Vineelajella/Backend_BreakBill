package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.GroupDTO;
import com.breakthebill.Break.the.Bill.model.Group;

import java.util.Optional;

public interface GroupService {
    Group createGroup(GroupDTO groupDTO);
    Optional<Group> getGroupById(Long id);
}
