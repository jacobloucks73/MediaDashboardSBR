package com.smugalpaca.mediadashboard.service;

import com.smugalpaca.mediadashboard.payload.JwtResponse;
import com.smugalpaca.mediadashboard.payload.LoginRequest;
import com.smugalpaca.mediadashboard.payload.RegisterRequest;
import com.smugalpaca.mediadashboard.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.smugalpaca.mediadashboard.models.Users;
import com.smugalpaca.mediadashboard.repository.UserRepository;
import com.smugalpaca.mediadashboard.util.JwtUtils;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class AuthService {


    private UserRepository userRepository;

    // For hashing passwords

    private BCryptPasswordEncoder passwordEncoder;

    // For authentication

    private AuthenticationManager authenticationManager;

    // For generating JWT tokens

    private JwtUtils jwtUtils;

    public void registerUser(RegisterRequest registerRequest) {
        // Create a new user entity and hash the password before saving
        Users user = new Users();
        user.setName(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        // Hash the password using BCrypt
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreated_At(Timestamp.from(Instant.now()));
        user.setUpdated_At(Timestamp.from(Instant.now()));
        user.setRole("user");


        userRepository.save(user);


    }

    public JwtResponse authenticateUser(LoginRequest loginRequest) {
        // Create an authentication token using username and password
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        // Set the authentication in the security context so that it is available for the session
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Generate a JWT token using our JwtUtils helper class
        String jwt = jwtUtils.generateJwtToken(authentication);

        // Return the JWT token in a response object
        return new JwtResponse(jwt);
    }
}
