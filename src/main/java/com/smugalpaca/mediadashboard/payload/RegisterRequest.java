package com.smugalpaca.mediadashboard.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String username;
    private String email;
    private String password;

    // Getters and Setters
}