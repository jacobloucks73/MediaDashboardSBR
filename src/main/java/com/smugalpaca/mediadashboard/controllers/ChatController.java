package com.smugalpaca.mediadashboard.controllers;


import com.smugalpaca.mediadashboard.models.ChatMessage;
import com.smugalpaca.mediadashboard.models.ChatSession;
import com.smugalpaca.mediadashboard.models.User;
import com.smugalpaca.mediadashboard.service.AIIntegrationService;
import com.smugalpaca.mediadashboard.service.ChatMessageService;
import com.smugalpaca.mediadashboard.service.ChatSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController
{
    @Autowired
    private final ChatSessionService ChatService;
    // for Chat Pages
    @Autowired
    private AIIntegrationService AIIntegrationService;
    //AI calls

    public ChatController(ChatSessionService chatSessionService, AIIntegrationService aiIntegrationService) {
        this.ChatService = chatSessionService;
        this.AIIntegrationService = aiIntegrationService;
    }

    @PostMapping("/chats")
    public ChatSession createChatSession(@AuthenticationPrincipal User user) {
        return ChatService.createSessionForUser(user);
    }

    @GetMapping("/chats/{sessionId}")
    public ChatSession getChatSession(@PathVariable Long sessionId, @AuthenticationPrincipal User user) {
        return ChatService.getSessionByIdAndUser(sessionId, user);
    }

    @PostMapping("/chats/{sessionId}/messages")
    public ChatMessage sendMessage(@PathVariable Long sessionId,                                                        // consider adding a chatmessage table to the db and change this to that so chatsession doesnt get overwhelmingly complicated
                                   @AuthenticationPrincipal User user,
                                   @RequestBody ChatMessage request) {

        ChatMessage userMessage = ChatMessageService.addUserMessage(sessionId, user, request.getMessage());             // make sure that the prompt goes through with exception testing

        String aiResponse = AIIntegrationService.getResponseForChat(sessionId, request.getMessage());

        return ChatMessageService.addBotMessage(sessionId, aiResponse);
    }

    @GetMapping("/chats")
    public List<ChatSession> listUserChats(@AuthenticationPrincipal User user) {
        return ChatService.getSessionsForUser(user);
    }

    @DeleteMapping("/chats/{sessionId}")
    public void deleteChatSession(@PathVariable Long sessionId, @AuthenticationPrincipal User user) {
        ChatService.deleteSession(sessionId, user);
    }
}