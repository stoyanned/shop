package com.example.shop.controllers;

import com.example.shop.exceptions.EmailAlreadyExistsException;
import com.example.shop.exceptions.UsernameAlreadyExistsException;
import com.example.shop.model.User;
import com.example.shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "user_registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        try {
            userService.registerUser(user);
            return "redirect:/login?success";
        } catch (UsernameAlreadyExistsException e) {
            return "redirect:/register?error=username";
        } catch (EmailAlreadyExistsException e) {
            return "redirect:/register?error=email";
        }
    }


}
