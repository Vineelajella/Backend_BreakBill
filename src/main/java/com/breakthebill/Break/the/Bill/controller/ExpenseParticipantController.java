package com.breakthebill.Break.the.Bill.controller;

import com.breakthebill.Break.the.Bill.DTO.ExpenseParticipantDTO;
import com.breakthebill.Break.the.Bill.model.ExpenseParticipant;
import com.breakthebill.Break.the.Bill.service.ExpenseParticipantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense-participants")
public class ExpenseParticipantController {

    private final ExpenseParticipantService service;

    public ExpenseParticipantController(ExpenseParticipantService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ExpenseParticipant> create(@RequestBody ExpenseParticipantDTO dto) {
        return ResponseEntity.ok(service.createExpenseParticipant(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseParticipant> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ExpenseParticipant>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
