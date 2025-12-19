package com.example.demo.controller;

import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    // Constructor injection
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // ---------------- REGISTER ----------------

    @PostMapping("/register")
    public UserResponseDTO register(@RequestBody User user) {

        User savedUser = userService.register(user);

        UserResponseDTO dto = new UserResponseDTO();
        dto.id = savedUser.getId();
        dto.email = savedUser.getEmail();
        dto.role = savedUser.getRole();

        return dto;
    }

    // ---------------- LOGIN ----------------

    @PostMapping("/login")
    public UserResponseDTO login(@RequestBody User user) {

        User found = userService.findByEmail(user.getEmail());

        UserResponseDTO dto = new UserResponseDTO();
        dto.id = found.getId();
        dto.email = found.getEmail();
        dto.role = found.getRole();

        return dto;
    }
}
