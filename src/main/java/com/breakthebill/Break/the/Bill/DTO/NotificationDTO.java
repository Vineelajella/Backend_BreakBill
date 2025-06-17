package com.breakthebill.Break.the.Bill.DTO;

import com.breakthebill.Break.the.Bill.model.Notification.NotificationType;
import lombok.Data;

@Data
public class NotificationDTO {
    private Long userId;
    private String message;
    private String title;
    private NotificationType type;
}
