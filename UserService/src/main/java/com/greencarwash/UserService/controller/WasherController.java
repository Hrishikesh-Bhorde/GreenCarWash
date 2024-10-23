package com.greencarwash.UserService.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greencarwash.UserService.entities.Role;
import com.greencarwash.UserService.entities.User;
import com.greencarwash.UserService.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("users/washer")
public class WasherController {
	
    @Autowired
    UserService service;

    // Register as Washer
    @PostMapping("/register")
    public ResponseEntity<?> createWasher(@Valid @RequestBody User userRequest) {
        try {
            User user = service.createUser(userRequest.getEmail(), userRequest.getPassword(), Set.of(Role.WASHER));
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating Washer: " + e.getMessage());
        }
    }

}
