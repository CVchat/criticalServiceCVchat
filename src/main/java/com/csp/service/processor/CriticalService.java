package com.csp.service.processor;

import com.csp.service.RestHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CriticalService {
    @Value("${rest.critical}")
    private String value;

    @Autowired
    RestHandlerService restHandlerService;

    public void allValues(String message) {
        restHandlerService.sendCommand(value,message);
    }
}
