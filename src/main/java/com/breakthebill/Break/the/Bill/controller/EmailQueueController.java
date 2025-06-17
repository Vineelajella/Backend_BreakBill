package com.breakthebill.Break.the.Bill.controller;

import com.breakthebill.Break.the.Bill.DTO.EmailQueueDTO;
import com.breakthebill.Break.the.Bill.model.EmailQueue;
import com.breakthebill.Break.the.Bill.service.EmailQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/email-queue")
public class EmailQueueController {

    private final EmailQueueService emailQueueService;

    @Autowired
    public EmailQueueController(EmailQueueService emailQueueService) {
        this.emailQueueService = emailQueueService;
    }

    @PostMapping
    public EmailQueue enqueueEmail(@RequestBody EmailQueueDTO dto) {
        return emailQueueService.enqueueEmail(dto);
    }

    @GetMapping
    public List<EmailQueue> getAllEmails() {
        return emailQueueService.getAllEmails();
    }
}
