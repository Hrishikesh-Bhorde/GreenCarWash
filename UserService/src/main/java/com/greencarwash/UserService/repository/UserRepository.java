package com.greencarwash.UserService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.greencarwash.UserService.entities.Role;
import com.greencarwash.UserService.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
	
	@Query("SELECT u FROM User u JOIN u.roles r WHERE r = :role")
    List<User> findUsersByRole(@Param("role") Role role);
	
}
