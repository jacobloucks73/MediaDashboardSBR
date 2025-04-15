package com.smugalpaca.mediadashboard.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AIIntegrationService {

    // Inject any necessary configuration properties, API keys, or REST clients

    private String apiKey;


    public String getResponseForChat(Long chatbot, String userMessage) {

        return "This is a dummy response from the AI service.";
    }
}
