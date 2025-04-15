package com.smugalpaca.mediadashboard.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@Entity
@Table(name = "chatmessage")
public class ChatMessage
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "SessionKey")
    private long sessionKey;

    @Column(nullable = false, name = "Message")
    private String message;

    @Column(nullable = false, name = "Created_at")
    private Timestamp created_At;

    @Column(nullable = true, name = "Updated_at")
    private Timestamp updated_At;


    public void setUser(User user) {
    }


}