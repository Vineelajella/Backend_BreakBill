package com.breakthebill.Break.the.Bill.controller;

import com.breakthebill.Break.the.Bill.DTO.SettlementDTO;
import com.breakthebill.Break.the.Bill.model.Settlement;
import com.breakthebill.Break.the.Bill.service.SettlementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/settlements")
public class SettlementController {

    private final SettlementService settlementService;

    public SettlementController(SettlementService settlementService) {
        this.settlementService = settlementService;
    }

    @PostMapping
    public ResponseEntity<Settlement> create(@RequestBody SettlementDTO dto) {
        return ResponseEntity.ok(settlementService.createSettlement(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Settlement> getById(@PathVariable Long id) {
        return settlementService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Settlement>> getAll() {
        return ResponseEntity.ok(settlementService.getAll());
    }
}
