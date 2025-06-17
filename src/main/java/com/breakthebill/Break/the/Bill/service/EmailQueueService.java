package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.EmailQueueDTO;
import com.breakthebill.Break.the.Bill.model.EmailQueue;

import java.util.List;

public interface EmailQueueService {
    EmailQueue enqueueEmail(EmailQueueDTO dto);
    List<EmailQueue> getAllEmails();
}
