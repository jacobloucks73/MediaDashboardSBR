package com.smugalpaca.mediadashboard.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

@Setter
@Getter
@Entity
@Table(name = "chatbot")
public class Chatbot
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "user_id")
    private long UserID;

    @Column(nullable = false, name = "Name")
    private String name;

    @Column(nullable = false, name = "Bio")
    private String description;

    @Column(nullable = false, name = "ContextPrompt")
    private String contextPrompt;

    @Column(nullable = false, name = "Created_At")
    private Timestamp created_At;

    @Column(nullable = false, name = "Updated_At")
    private Timestamp updated_At;

    @Column(nullable = false, name = "AvatarURL")
    private String AvatarURL;


    public Chatbot(Long botId, String name, String description, String avatarUrl, String contextPrompt) {
        this.id = botId;
        this.name = name;
        this.description = description;
        this.AvatarURL = avatarUrl;
        this.contextPrompt = contextPrompt;
        this.created_At = new Timestamp(System.currentTimeMillis());
        this.updated_At = new Timestamp(System.currentTimeMillis());
    }


    public Chatbot() {
        System.out.println("incorrect constructor ");
    }
}