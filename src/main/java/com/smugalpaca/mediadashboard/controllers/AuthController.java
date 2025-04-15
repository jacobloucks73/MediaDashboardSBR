// AuthController.java
package com.smugalpaca.mediadashboard.controllers;

import com.smugalpaca.mediadashboard.AuthUtility.LoginRequest;
import com.smugalpaca.mediadashboard.AuthUtility.RegisterRequest;
import com.smugalpaca.mediadashboard.AuthUtility.JwtResponse;
import com.smugalpaca.mediadashboard.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Endpoint for user registration
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest registerRequest) {
        // Calls the service to register the user, which will hash the password and save the user
        authService.registerUser(registerRequest);
        return ResponseEntity.ok("User registered successfully!");
    }

    // Endpoint for user login
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        // The service authenticates the user and returns a JWT token if successful
        JwtResponse jwtResponse = authService.authenticateUser(loginRequest);
        return ResponseEntity.ok(jwtResponse);
    }
}
