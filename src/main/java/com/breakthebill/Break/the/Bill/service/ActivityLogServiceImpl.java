package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.ActivityLogDTO;
import com.breakthebill.Break.the.Bill.model.ActivityLog;
import com.breakthebill.Break.the.Bill.repository.ActivityLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository repository;

    public ActivityLogServiceImpl(ActivityLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public ActivityLog createLog(ActivityLogDTO dto) {
        ActivityLog log = new ActivityLog();
        log.setUserId(dto.getUserId());
        log.setGroupId(dto.getGroupId());
        log.setActionType(dto.getActionType());
        log.setDescription(dto.getDescription());
        log.setDetails(dto.getDetails());
        log.setTimestamp(dto.getTimestamp());
        return repository.save(log);
    }

    @Override
    public List<ActivityLog> getAllLogs() {
        return repository.findAll();
    }
}
