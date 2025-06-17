package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.GroupOwnershipTransferDTO;
import com.breakthebill.Break.the.Bill.model.GroupOwnershipTransfer;

import java.util.List;

public interface GroupOwnershipTransferService {
    GroupOwnershipTransfer createTransfer(GroupOwnershipTransferDTO dto);
    List<GroupOwnershipTransfer> getAllTransfers();
}
