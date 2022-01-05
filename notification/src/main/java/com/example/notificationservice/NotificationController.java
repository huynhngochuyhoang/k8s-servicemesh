package com.example.notificationservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("newest")
    public String getNewestNotification() {
        LocalDateTime now = LocalDateTime.now();
        logger.info("Getting notification check at {}", now);
        return "Getting new notification at " + now + " from app version " + appVersion;
    }
}
