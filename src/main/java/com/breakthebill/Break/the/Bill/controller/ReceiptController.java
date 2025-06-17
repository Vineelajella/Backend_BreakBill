package com.breakthebill.Break.the.Bill.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.breakthebill.Break.the.Bill.DTO.ReceiptDTO;
import com.breakthebill.Break.the.Bill.model.Receipt;
import com.breakthebill.Break.the.Bill.service.ReceiptService;

@RestController
@RequestMapping("/api/receipts")
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @PostMapping
    public ResponseEntity<Receipt> createReceipt(@RequestBody ReceiptDTO dto) {
        Receipt savedReceipt = receiptService.createReceipt(dto);
        return ResponseEntity.ok(savedReceipt);
    }

    @GetMapping("/expense/{expenseId}")
    public ResponseEntity<Receipt> getByExpenseId(@PathVariable Long expenseId) {
        Optional<Receipt> receipt = receiptService.getReceiptById(expenseId);
        return receipt.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
