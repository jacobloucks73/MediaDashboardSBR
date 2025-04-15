package com.smugalpaca.mediadashboard.service;

import com.smugalpaca.mediadashboard.models.Chatbot;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ChatbotService
{

    public List<Chatbot> getAllBots() {
        return Arrays.asList(
                new Chatbot(1L, "Socrates", "philosopher1", "src/main/resources/Socrates.jpg", "undecided prompt"),
                new Chatbot(2L, "Aristotle", "philosopher2", "src/main/resources/Aristotle.jpg", "undecided prompt"),
                new Chatbot(3L, "Nietzsche", "philosopher3", "src/main/resources/Nietzsche.jpg", "undecided prompt")

                //public Chatbot(Long botId, String name, String description, String avatarUrl, String contextPrompt) {
        );
    }

}
