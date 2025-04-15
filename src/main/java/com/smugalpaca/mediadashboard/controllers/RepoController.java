package com.smugalpaca.mediadashboard.controllers;

import com.smugalpaca.mediadashboard.models.Chatbot;
import com.smugalpaca.mediadashboard.service.ChatbotService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/repository")
public class RepoController
{
    // private final ChatSessionService ChatService;

    private ChatbotService chatbotService;

    public RepoController(ChatbotService chatbotservice) {
        this.chatbotService = chatbotservice;
    }


    //List<ChatSession> userSession = ChatSessionService.findByUser(user);

    // Your bots available in the app (could come from DB or hardcoded for now)
    @GetMapping("/chatbots")
    public List<Chatbot> getChatbots() {
        return chatbotService.getAllBots();
    }


}
