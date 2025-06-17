package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.EmailQueueDTO;
import com.breakthebill.Break.the.Bill.model.EmailQueue;
import com.breakthebill.Break.the.Bill.model.EmailQueue.EmailStatus;
import com.breakthebill.Break.the.Bill.repository.EmailQueueRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class EmailQueueServiceImpl implements EmailQueueService {

    private final EmailQueueRepository repository;

    public EmailQueueServiceImpl(EmailQueueRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmailQueue enqueueEmail(EmailQueueDTO dto) {
        EmailQueue email = new EmailQueue();
        email.setToEmail(dto.getToEmail());
        email.setSubject(dto.getSubject());
        email.setBody(dto.getBody());
        email.setStatus(EmailStatus.PENDING);
        email.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return repository.save(email);
    }

    @Override
    public List<EmailQueue> getAllEmails() {
        return repository.findAll();
    }
}
