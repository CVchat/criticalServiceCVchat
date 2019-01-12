package com.csp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestHandlerService {
    @Value("${rest.url}")
    private String url;

    public void sendCommand(String actionType, String message) {
       RestTemplate restTemplate = new RestTemplate();
        String requestJson = message;
        HttpHeaders headers  = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
        System.out.println(url + actionType);
        try {
            String answer = restTemplate.postForObject(url + actionType, entity, String.class);
            System.out.println("Recieved answer from rest: " + answer);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
