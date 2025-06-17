package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.ActivityLogDTO;
import com.breakthebill.Break.the.Bill.model.ActivityLog;

import java.util.List;

public interface ActivityLogService {
    ActivityLog createLog(ActivityLogDTO dto);
    List<ActivityLog> getAllLogs();
}
