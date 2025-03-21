package com.smugalpaca.mediadashboard.util;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private final String jwtSecret = "yourSecretKey"; // Replace with a secure key
    private final int jwtExpirationMs = 86400000; // 1 day in milliseconds

    public String generateJwtToken(Authentication authentication) {
        // Extract username or other user details as needed
        String username = authentication.getName();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
}