package com.breakthebill.Break.the.Bill.service;


import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.breakthebill.Break.the.Bill.DTO.ReceiptDTO;
import com.breakthebill.Break.the.Bill.model.Receipt;
import com.breakthebill.Break.the.Bill.repository.ReceiptRepository;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    @Override
    public Receipt createReceipt(ReceiptDTO dto) {
        if (receiptRepository.existsById(dto.getExpenseId())) {
            throw new IllegalStateException("Receipt already exists for this expense.");
        }

        Receipt receipt = new Receipt();
        receipt.setExpenseId(dto.getExpenseId());
        receipt.setImageUrl(dto.getImageUrl());
        receipt.setImageData(dto.getImageData());
        receipt.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        return receiptRepository.save(receipt);
    }

    @Override
    public Optional<Receipt> getReceiptById(Long id) {
        return receiptRepository.findById(id);
    }
}
