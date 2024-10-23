package com.greencarwash.UserService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greencarwash.UserService.entities.Role;
import com.greencarwash.UserService.entities.User;
import com.greencarwash.UserService.service.UserService;



@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    
    // Update User Profile
    @PutMapping("update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody User user)
    {
    	try {
        	return ResponseEntity.ok(service.updateUser(user, id));
    	}
    	catch(Exception e)
    	{
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    	}
    }
    

    // Get All Users
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllUsers()
    {
    	try {
    		List<User> allUsers = service.getAllUsers();
            return ResponseEntity.status(HttpStatus.CREATED).body(allUsers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    	
    }
    
    @GetMapping("getAll/role={role}")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable("role") String role) {
        try { 
            Role userRole = Role.valueOf(role.toUpperCase());
            List<User> users = service.getUsersByRole(userRole);
            return ResponseEntity.ok(users);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
    
    
    
    
}
