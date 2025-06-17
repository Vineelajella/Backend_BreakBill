package com.breakthebill.Break.the.Bill.controller;

import com.breakthebill.Break.the.Bill.DTO.GroupMemberDTO;
import com.breakthebill.Break.the.Bill.model.GroupMember;
import com.breakthebill.Break.the.Bill.service.GroupMemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/group-members")
public class GroupMemberController {

    private final GroupMemberService groupMemberService;

    public GroupMemberController(GroupMemberService groupMemberService) {
        this.groupMemberService = groupMemberService;
    }

    @PostMapping
    public ResponseEntity<GroupMember> addMember(@RequestBody GroupMemberDTO dto) {
        return ResponseEntity.ok(groupMemberService.addMember(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupMember> getMemberById(@PathVariable Long id) {
        return groupMemberService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/group/{groupId}")
    public ResponseEntity<List<GroupMember>> getMembersByGroup(@PathVariable Long groupId) {
        return ResponseEntity.ok(groupMemberService.getByGroup(groupId));
    }
}
