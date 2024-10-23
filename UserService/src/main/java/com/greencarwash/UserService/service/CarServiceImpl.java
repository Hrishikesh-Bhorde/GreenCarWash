package com.greencarwash.UserService.service;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greencarwash.UserService.entities.Car;
import com.greencarwash.UserService.entities.Role;
import com.greencarwash.UserService.entities.User;
import com.greencarwash.UserService.repository.CarRepository;
import com.greencarwash.UserService.repository.UserRepository;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarRepository repo;

	@Autowired
	UserRepository userRepo;

	@Override
	public Car addCar(Long clientId, Car car) throws AccessDeniedException {
		User user = userRepo.findById(clientId).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		Set<Role> roles = user.getRoles();

		if (roles.contains(Role.CLIENT)) {
			car.setClient(user);
			return repo.save(car);
		} else {
			throw new AccessDeniedException("Washer cannot add a car");
		}
	}

	@Override
	public Car getCarById(Long id) {
		Car c = repo.findById(id).get();
		if (c == null) {
			throw new RuntimeException("No Car found");
		} else
			return c;
	}

	@Override
	public List<Car> getAllCarsByClient(Long client_id) {
		List<Car> list = repo.findByClientId(client_id);
		if (list.isEmpty()) {
			throw new RuntimeException("No Cars found for client with Id: " + client_id);
		}
		return list;
	}

	@Override
	public Car deleteCar(Long id) {
		// TODO Auto-generated method stub
		Car c = repo.findById(id).get();
		if (c != null) {
			repo.deleteById(id);
			return c;
		} else {
			throw new RuntimeException("Car Not found !");
		}
	}

}
