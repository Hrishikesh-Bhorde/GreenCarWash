package com.greencarwash.OrderService.service;

import java.util.List;

import com.greencarwash.OrderService.entity.Order;
import com.greencarwash.OrderService.entity.Order.Status;

public interface OrderService {
	
	Order placeOrder(Order order);            // Only Client can use
	
	Order updateOrderDetails(Long order_id, Order order);
	
	Order cancelOrderRequest(Long order_id);
	
	Order acceptOrder(Long order_id, Long washer_id);        // Can be used Washer
	
	Order updateOrderStatus(Long order_id, Status status);   // Can be used Washer
	
	Order getOrder(Long order_id);
	
	List<Order> getOrdersByStatus(Status status);
	
	List<Order> getOrdersByCar(Long car_id);
	
	List<Order> getOrdersByClient(Long client_id);
	
	List<Order> getOrdersByWasher(Long washer_id);


	
}
