package com.smugalpaca.mediadashboard.service;


import com.smugalpaca.mediadashboard.models.ChatSession;
import com.smugalpaca.mediadashboard.models.User;
import com.smugalpaca.mediadashboard.repos.ChatSessionRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ChatSessionService {

    private final ChatSessionRepository chatSessionRepository;

    // Constructor injection (preferred over field injection)
    public ChatSessionService(ChatSessionRepository chatSessionRepository) {
        this.chatSessionRepository = chatSessionRepository;
    }

    public ChatSession createSessionForUser(User user){
        if (user == null) {
            System.out.println("user is null1");
            return null;
        }

        ChatSession session = new ChatSession();
        session.setUser(user);
        session.setCreated_At(Timestamp.valueOf(LocalDateTime.now()));
        session.setTitle("New Chat");

        return chatSessionRepository.save(session);
    }

    public ChatSession getSessionByIdAndUser(Long sessionId, User user) {
        if (sessionId == null || user == null) {
            System.out.println("sessionID or user is null1");
            return null;
        }

        return null; //fix me

    }

    public List<ChatSession> getSessionsForUser(User user) {
        if (user == null) {
            System.out.println("user is null3");
            return null;
        }

        return chatSessionRepository.findByUser(user);
    }

    public void deleteSession(Long sessionId, User user) {
        if (sessionId == null || user == null) {
            System.out.println("sessionID or user is null");
            return;
        }

        Optional<ChatSession> sessionOpt = chatSessionRepository.findById(sessionId);
        if (sessionOpt.isPresent()) {
            ChatSession session = sessionOpt.get();
            if (session.getUser().getId() == user.getId()) {
                chatSessionRepository.delete(session);
            } else {
                System.out.println("Unauthorized: User doesn't own this session.");
                System.out.println("DEBUG: user.getId(): " + user.getId());
                System.out.println("DEBUG: session.getUserId(): " + session.getUser().getId());
            }
        } else {
            System.out.println("Session not found.");
        }
    }
}
