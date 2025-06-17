package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.GroupOwnershipTransferDTO;
import com.breakthebill.Break.the.Bill.model.GroupOwnershipTransfer;
import com.breakthebill.Break.the.Bill.repository.GroupOwnershipTransferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupOwnershipTransferServiceImpl implements GroupOwnershipTransferService {

    private final GroupOwnershipTransferRepository repository;

    public GroupOwnershipTransferServiceImpl(GroupOwnershipTransferRepository repository) {
        this.repository = repository;
    }

    @Override
    public GroupOwnershipTransfer createTransfer(GroupOwnershipTransferDTO dto) {
        GroupOwnershipTransfer transfer = new GroupOwnershipTransfer();
        transfer.setGroupId(dto.getGroupId());
        transfer.setFromUserId(dto.getFromUserId());
        transfer.setToUserId(dto.getToUserId());
        transfer.setTransferredAt(dto.getTransferredAt());
        return repository.save(transfer);
    }

    @Override
    public List<GroupOwnershipTransfer> getAllTransfers() {
        return repository.findAll();
    }
}
