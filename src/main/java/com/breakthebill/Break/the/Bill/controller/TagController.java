package com.breakthebill.Break.the.Bill.controller;

import com.breakthebill.Break.the.Bill.DTO.TagDTO;
import com.breakthebill.Break.the.Bill.model.Tag;
import com.breakthebill.Break.the.Bill.service.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public Tag createTag(@RequestBody TagDTO dto) {
        return tagService.createTag(dto);
    }

    @GetMapping
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @PostMapping("/{tagId}/assign/{expenseId}")
    public String assignTagToExpense(@PathVariable Long tagId, @PathVariable Long expenseId) {
        tagService.assignTagToExpense(tagId, expenseId);
        return "Tag assigned successfully!";
    }
}
