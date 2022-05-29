package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Order;
import com.app.reposity.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;
	
	public List<Order> listOrder(){
		return (List<Order>) repository.findAll();
	}
	
	public Order saveOrder(Order order) {
		return repository.save(order);
	}

	public Order getOrderById(int id) {
		return repository.findById(id).orElse(null);
	}
	public void deleteOrder(int id) {
		repository.deleteById(id);
	}
	
	public List<Order> findOrderByCustomer(int customer_id){
		return repository.findOrderByCustomer(customer_id);
	}
}
