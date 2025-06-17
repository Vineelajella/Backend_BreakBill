package com.breakthebill.Break.the.Bill.controller;

import com.breakthebill.Break.the.Bill.DTO.ActivityLogDTO;
import com.breakthebill.Break.the.Bill.model.ActivityLog;
import com.breakthebill.Break.the.Bill.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/activity-logs")
public class ActivityLogController {

    private final ActivityLogService activityLogService;

    @Autowired
    public ActivityLogController(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }

    @PostMapping
    public ActivityLog create(@RequestBody ActivityLogDTO dto) {
        return activityLogService.createLog(dto);
    }

    @GetMapping
    public List<ActivityLog> getAll() {
        return activityLogService.getAllLogs();
    }
}
