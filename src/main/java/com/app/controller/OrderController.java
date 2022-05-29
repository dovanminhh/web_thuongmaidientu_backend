package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Order;
import com.app.service.OrderService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/")
public class OrderController {
	@Autowired
	private OrderService service;
	
	@GetMapping("order")
	public List<Order> findAllOrder(){
		return service.listOrder();
	}
	
	@PostMapping("order/addOrder")
	public Order addOrder(@RequestBody Order order){
		return service.saveOrder(order);
	}
	@GetMapping("order/orderById/{id}")
	public Order findOrderById(@PathVariable int id) {
		return service.getOrderById(id);
	}
	@DeleteMapping("order/deleteOrder/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable int id){
		service.deleteOrder(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("order/orderByCustomer/{customer_id}")
	public List<Order> findOrderByCustomer(@PathVariable("customer_id") int customer_id){
		return service.findOrderByCustomer(customer_id);
	}
}
