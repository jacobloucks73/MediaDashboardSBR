package com.smugalpaca.mediadashboard.controllers;

import com.smugalpaca.mediadashboard.AuthUtility.RegisterRequest;
import com.smugalpaca.mediadashboard.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthPageController {

    private AuthService authService;

    AuthPageController(AuthService authService) {
        this.authService = authService;
    }

    // Display the registration page
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        // Add an empty RegisterRequest object to the model
        model.addAttribute("registerRequest", new RegisterRequest());
        return "register";  // Resolves to register.html (in src/main/resources/templates)
    }

    // Display the login page
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        // Optionally add attributes to the model if needed
        return "login";  // This resolves to login.html in your templates folder
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("registerRequest") RegisterRequest registerRequest) {
        authService.registerUser(registerRequest);
        // After registration, redirect to the homepage
        return "redirect:/home";
    }
}
