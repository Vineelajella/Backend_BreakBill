package com.breakthebill.Break.the.Bill.service;

import com.breakthebill.Break.the.Bill.DTO.NotificationDTO;
import com.breakthebill.Break.the.Bill.model.Notification;
import com.breakthebill.Break.the.Bill.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification createNotification(NotificationDTO dto) {
        Notification notification = new Notification();
        notification.setUserId(dto.getUserId());
        notification.setMessage(dto.getMessage());
        notification.setTitle(dto.getTitle());
        notification.setType(dto.getType());
        notification.setRead(false);
        notification.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    @Override
    public Optional<Notification> getById(Long id) {
        return notificationRepository.findById(id);
    }
}
