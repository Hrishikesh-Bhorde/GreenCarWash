package com.greencarwash.OrderService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greencarwash.OrderService.entity.Order;
import com.greencarwash.OrderService.entity.Order.Status;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	List<Order> findByCar(Long car_id);
	
	List<Order> findByClient(Long client_id);

	List<Order> findByWasher(Long washer_id);
	
	List<Order> findByStatus(Status status);

}
