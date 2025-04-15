package com.smugalpaca.mediadashboard.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "chatsession")
public class ChatSession
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @Column(nullable = false, name = "Title")
    private String title;

    @Column(nullable = false, name = "TimeCreated")
    private Timestamp created_At;

    @Column(nullable = true, name = "TimeUpdated")
    private Timestamp updated_At;


    public void setUser(User user) {
    }

    List<ChatSession> findByUser(User userId) {
        return null;
    }
}