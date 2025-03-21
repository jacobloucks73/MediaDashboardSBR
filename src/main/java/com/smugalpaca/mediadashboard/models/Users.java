package com.smugalpaca.mediadashboard.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@Entity

@Table(name ="users")
public class Users
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "Username")
    private String name;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "Password")
    private String password;

    @Column(nullable = false, name = "role")
    private String role;

    @Column(nullable = false, name = "Created_At")
    private Timestamp created_At;

    @Column(nullable = false, name = "Updated_At")
    private Timestamp updated_At;


}
