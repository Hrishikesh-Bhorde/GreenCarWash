package com.greencarwash.UserService.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.greencarwash.UserService.entities.Role;
import com.greencarwash.UserService.entities.User;

public interface UserService {

	User createUser(String email, String password,Set<Role> roles);
	
	Optional<User> getById(Long id);
	
	List<User> getAllUsers();
	
	User updateUser(User u, Long id);
	
	String deleteUser(Long id);
	
	 List<User> getUsersByRole(Role role);
}
