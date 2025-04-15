package com.smugalpaca.mediadashboard.AuthUtility;

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

}