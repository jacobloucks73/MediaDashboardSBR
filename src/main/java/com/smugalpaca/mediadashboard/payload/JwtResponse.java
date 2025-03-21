package com.smugalpaca.mediadashboard.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class JwtResponse {
    private String token;
    private String tokenType = "Bearer";

    public JwtResponse(String token) {
        this.token = token;
    }

    // Getters and Setters
}