package com.csp.service;

import com.csp.service.processor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @Autowired
    RestHandlerService restHandlerService;
    @Autowired
    CriticalService criticalService;

    @KafkaListener(topics = "critical_message", groupId = "gr1")
    public void criticalMessage(String message) {
        System.out.println("critical_message");
        System.out.println(message);

        criticalService.allValues(message);
    }
}