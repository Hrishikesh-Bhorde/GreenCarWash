package com.greencarwash.OrderService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greencarwash.OrderService.entity.Order;
import com.greencarwash.OrderService.entity.Order.Status;
import com.greencarwash.OrderService.service.OrderService;

@RestController
@RequestMapping("/order")
class OrderController {

	@Autowired
	OrderService service;

	@PostMapping("create")
	public ResponseEntity<?> createOrder(@RequestBody Order order) {
		try {
			return ResponseEntity.ok(service.placeOrder(order));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error placing order: " + e.getMessage());
		}
	}

	@PutMapping("update/{order_id}")
	public ResponseEntity<?> updateDetails(@PathVariable Long order_id, @RequestBody Order order) {
		try {

			Order updatedOrder = service.updateOrderDetails(order_id, order);
			return ResponseEntity.ok(updatedOrder);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error updating order Details: " + e.getMessage());
		}
	}

	@PutMapping("change/{order_id}/status={status}")
	public ResponseEntity<?> changeStatus(@PathVariable("order_id") Long order_id,
			@PathVariable("status") Status status) {
		try {

			Order updatedOrder = service.updateOrderStatus(order_id, status);
			return ResponseEntity.ok(updatedOrder);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error updating status:" + e.getMessage());
		}
	}

	@DeleteMapping("/cancel/{order_id}")
	public ResponseEntity<?> cancelOrder(@PathVariable Long order_id) {
		try {

			Order o = service.cancelOrderRequest(order_id);
			return ResponseEntity.ok("Order Cancelled: " + o);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error Cancelling order:" + e.getMessage());
		}
	}

	@GetMapping("{order_id}")
	public ResponseEntity<?> getOrderById(@PathVariable Long order_id) {
		try {
			Order o = service.getOrder(order_id);
			return ResponseEntity.ok(o);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error fetching order:" + e.getMessage());
		}
	}

	@GetMapping("getByCarid={car_id}")
	public ResponseEntity<?> getByCar(@PathVariable Long car_id) {
		try {

			List<Order> orderList = service.getOrdersByCar(car_id);
			return ResponseEntity.ok(orderList);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error fetching orders:" + e.getMessage());
		}
	}

	@GetMapping("getByClientid={client_id}")
	public ResponseEntity<?> getByClient(@PathVariable Long client_id) {
		try {

			List<Order> orderList = service.getOrdersByClient(client_id);
			return ResponseEntity.ok(orderList);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error fetching orders:" + e.getMessage());
		}
	}

	@GetMapping("getByWasherid={washer_id}")
	public ResponseEntity<?> getByWasher(@PathVariable Long washer_id) {
		try {

			List<Order> orderList = service.getOrdersByWasher(washer_id);
			return ResponseEntity.ok(orderList);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error fetching orders:" + e.getMessage());
		}
	}

	@PutMapping("acceptOrder/{order_id}/{washer_id}")
	public ResponseEntity<?> getByWasher(@PathVariable Long order_id, @PathVariable Long washer_id) {
	try {
		
		return ResponseEntity.ok(service.acceptOrder(order_id, washer_id));
		
	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong: " + e.getMessage());
	}
	}
	
	@GetMapping("status={status}")
	public ResponseEntity<?> getByStatus(@PathVariable Status status) {
	try {
		
		return ResponseEntity.ok(service.getOrdersByStatus(status));
		
	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to fetch orders: " + e.getMessage());
	}
	}
	

}