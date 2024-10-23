package com.greencarwash.UserService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greencarwash.UserService.entities.Car;
import com.greencarwash.UserService.service.CarService;
import com.greencarwash.UserService.service.CarServiceImpl;

import jakarta.validation.Valid;

@RequestMapping("/car")
@RestController
public class CarController {

	@Autowired
	CarService service;

	@PostMapping("addCar/client={id}")
	public ResponseEntity<?> addCar(@Valid @PathVariable("id") Long id,  @RequestBody Car car) {
		try {
			return ResponseEntity.ok(service.addCar(id, car));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding car: " + e.getMessage());
		}

	}

	@GetMapping("getCars/client={id}")
	public ResponseEntity<?> getCars(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(service.getAllCarsByClient(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error fetching cars: " + e.getMessage());
		}
	}

	@GetMapping("getCar={id}")
	public ResponseEntity<?> getCarById(@PathVariable Long id) {
		try {
			Car car = service.getCarById(id);
			return ResponseEntity.ok(car);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No cars found: " + e.getMessage());
		}

	}

}
