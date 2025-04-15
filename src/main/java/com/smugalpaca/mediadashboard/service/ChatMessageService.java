package com.smugalpaca.mediadashboard.service;

import com.smugalpaca.mediadashboard.models.ChatMessage;
import com.smugalpaca.mediadashboard.models.User;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageService {

    //make the message and send it off to AI, get response and send it off to the session to store
    public static ChatMessage addBotMessage(Long sessionId, String aiResponse) {

        if(sessionId == null){

            System.out.println("sessionID is null2");
            return null;

        }

        if(aiResponse == null){

            System.out.println("response is null1");
            return null;

        }

        // if both are valid, store the AI message to archive via chatmessage service

        return null;
    } //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


    public static ChatMessage addUserMessage(Long sessionId, User user, String aiResponse) {

        if(sessionId == null){

            System.out.println("sessionID is null2");
            return null;

        }

        if(aiResponse == null){

            System.out.println("response is null1");
            return null;

        }

        // if both are valid, store the user message to archive via chatmessage service

        return null;
    } //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

}
