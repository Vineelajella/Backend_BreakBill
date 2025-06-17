package com.breakthebill.Break.the.Bill.service;


import java.util.Optional;

import com.breakthebill.Break.the.Bill.DTO.ReceiptDTO;
import com.breakthebill.Break.the.Bill.model.Receipt;

public interface ReceiptService {
    Receipt createReceipt(ReceiptDTO dto);
    Optional<Receipt> getReceiptById(Long id);
}
