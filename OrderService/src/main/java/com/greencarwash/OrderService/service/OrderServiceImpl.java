package com.greencarwash.OrderService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greencarwash.OrderService.entity.Order;
import com.greencarwash.OrderService.entity.Order.Status;
import com.greencarwash.OrderService.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository repo;
	
	private double totalCost = 0;


	@Override
	public Order placeOrder(Order order) {
		// TODO Auto-generated method stub
		totalCost = order.getBasePrice();
		order.getAddOns().forEach(a -> this.totalCost += a.getPrice());
		order.setTotal_cost(totalCost);
		return repo.save(order);
	}

	@Override
	public Order updateOrderDetails(Long order_id, Order order) {
		// TODO Auto-generated method stub

	    Order existingOrder = repo.findById(order_id).orElse(null);
	    
	    if (existingOrder != null) {
	        if (order.getDate() != null) {
	            existingOrder.setDate(order.getDate());
	        }
	        if (order.getLocation() != null) {
	            existingOrder.setLocation(order.getLocation());
	        }
	        if (order.getNote() != null) {
	            existingOrder.setNote(order.getNote());
	        }
	        if (order.getTotal_cost() != 0.0) {
	            existingOrder.setTotal_cost(order.getTotal_cost());
	        }
	        if (order.getClient() != null) {
	            existingOrder.setClient(order.getClient());
	        }
	        if (order.getCar() != null) {
	            existingOrder.setCar(order.getCar());
	        }
	        if (order.getWasher() != null) {
	            existingOrder.setWasher(order.getWasher());
	        }
	        if (order.getAddOns() != null) {
	            existingOrder.setAddOns(order.getAddOns());
	        }
	        
	        return repo.save(existingOrder);
	    } else {
	        throw new RuntimeException("Order with ID: " + order_id + " not found.");
	    }
	}


	@Override
	public Order cancelOrderRequest(Long order_id) {
		// TODO Auto-generated method stub
	    Order o = repo.findById(order_id).orElse(null);
	    if (o != null)
	    {
	    	repo.deleteById(order_id);
	    	return o;
	    }
	    else 
	    {
	        throw new RuntimeException("Order with ID: " + order_id + " not found.");
	    }
	}

	@Override
	public Order updateOrderStatus(Long order_id, Status status) {
		// TODO Auto-generated method stub
	    Order o = repo.findById(order_id).orElse(null);
	    
	    if (o != null)
	    {
	    	o.setStatus(status);
	    	return repo.save(o);
	    }
	    else 
	    {
	        throw new RuntimeException("Something went wrong with status change");
	    }
	}
	

	@Override
	public Order getOrder(Long order_id) {
		// TODO Auto-generated method stub
		return repo.findById(order_id).get();
	}

	@Override
	public List<Order> getOrdersByCar(Long car_id) {
		// TODO Auto-generated method stub
		return repo.findByCar(car_id);
	}

	@Override
	public List<Order> getOrdersByClient(Long client_id) {
		// TODO Auto-generated method stub
		return repo.findByClient(client_id);
	}

	@Override
	public List<Order> getOrdersByWasher(Long washer_id) {
		// TODO Auto-generated method stub
		return repo.findByWasher(washer_id);
	}

	@Override
	public Order acceptOrder(Long order_id, Long washer_id) {
		// TODO Auto-generated method stub
	    Order o = repo.findById(order_id).orElse(null);
	    
	    if(o != null)
	    {
	    	o.setWasher(washer_id);
	    	o.setStatus(Status.ACCEPTED);
	    	
	    	return repo.save(o);
	    }
	    else
	    {
	        throw new RuntimeException("Something went wrong"); 
	    }
	}

	@Override
	public List<Order> getOrdersByStatus(Status status) {
		// TODO Auto-generated method stub
		return repo.findByStatus(status);
	}


}
