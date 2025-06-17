package com.breakthebill.Break.the.Bill.controller;

import com.breakthebill.Break.the.Bill.DTO.GroupOwnershipTransferDTO;
import com.breakthebill.Break.the.Bill.model.GroupOwnershipTransfer;
import com.breakthebill.Break.the.Bill.service.GroupOwnershipTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ownership-transfers")
public class GroupOwnershipTransferController {

    private final GroupOwnershipTransferService transferService;

    @Autowired
    public GroupOwnershipTransferController(GroupOwnershipTransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public GroupOwnershipTransfer createTransfer(@RequestBody GroupOwnershipTransferDTO dto) {
        return transferService.createTransfer(dto);
    }

    @GetMapping
    public List<GroupOwnershipTransfer> getAllTransfers() {
        return transferService.getAllTransfers();
    }
}
