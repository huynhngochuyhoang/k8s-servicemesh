package com.example.checknotificationservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/checkNotification")
public class CheckNotificationController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Value("${notification.service}")
    private String notificationService;

    @GetMapping("refresh")
    public String refresh() {
        logger.info("Refresh list notification");
        String response = restTemplate.getForObject("http://" + notificationService + ":8081/api/notification/newest", String.class);
        logger.info("Received new notification");
        return response;
    }
}
