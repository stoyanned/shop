package com.example.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Return the view name for the login page
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied"; // Return the view name for the access denied page
    }
}
