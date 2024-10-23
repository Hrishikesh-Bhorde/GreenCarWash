package com.greencarwash.UserService.service;

import java.nio.file.AccessDeniedException;
import java.util.List;

import com.greencarwash.UserService.entities.Car;

public interface CarService {

	Car addCar(Long id, Car car) throws AccessDeniedException;
	
	Car getCarById(Long id);

	List<Car> getAllCarsByClient(Long client_id);
	
	Car deleteCar(Long id);
	
}
