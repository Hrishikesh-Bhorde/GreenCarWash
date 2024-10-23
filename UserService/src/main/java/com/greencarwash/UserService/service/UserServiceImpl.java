package com.greencarwash.UserService.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.greencarwash.UserService.entities.Role;
import com.greencarwash.UserService.entities.User;
import com.greencarwash.UserService.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	UserRepository repo;

	@Autowired
	PasswordEncoder hasher;

	@Override
	public User createUser(String email, String password,Set<Role> roles) {
		// TODO Auto-generated method stub
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(hasher.encode(password));
		// user.setRole(role);
		user.setRoles(roles);
		
		return repo.save(user);
	}

	@Override
	public Optional<User> getById(Long id) {
		// TODO Auto-generated method stub
		Optional<User> user = repo.findById(id);
		if(user == null)
		{
			throw new UsernameNotFoundException("User not found");
		}
		else
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public User updateUser(User u, Long id) {
	    // TODO Auto-generated method 
	    User user = repo.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
	    
	    if(u.getName() != null) {
	        user.setName(u.getName());
	    }
	    if(u.getAddress() != null) {
	        user.setAddress(u.getAddress());
	    }
	    if(u.getPassword() != null) {
	        user.setPassword(u.getPassword());
	    }
	    if(u.getProfilePic() != null) {
	        user.setProfilePic(u.getProfilePic());
	    }
	    if(u.getPhoneNo() != null) {
	        user.setPhoneNo(u.getPhoneNo());
	    }
	    
	    return repo.save(user);
	}

	@Override
	public String deleteUser(Long id) {
		// TODO Auto-generated method stub
		Optional<User> u = repo.findById(id);
		
		if (u.isPresent())
		{
			repo.deleteById(id);
			return "Deleted User";
		}
		else
		{
			throw new UsernameNotFoundException("User Not Found");
		}
	
	}
	
	@Override
    public List<User> getUsersByRole(Role role) {
        return repo.findUsersByRole(role);
    }


}
