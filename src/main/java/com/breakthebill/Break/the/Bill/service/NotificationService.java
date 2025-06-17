package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.NotificationDTO;
import com.breakthebill.Break.the.Bill.model.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationService {
    Notification createNotification(NotificationDTO dto);
    List<Notification> getNotificationsByUserId(Long userId);
    Optional<Notification> getById(Long id);
}
