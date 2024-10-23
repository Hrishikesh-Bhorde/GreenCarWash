package com.greencarwash.UserService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greencarwash.UserService.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

	List<Car> findByClientId(Long client_id);
	
}
