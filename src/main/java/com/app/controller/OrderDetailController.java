package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.OrderDetail;
import com.app.service.OrderDetailService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/")
public class OrderDetailController {
	@Autowired
	private OrderDetailService service;
	
	@GetMapping("orderDetail")
	public List<OrderDetail> findAllOrderDetail(){
		return service.listOrderDetail();
	}
	
	@PostMapping("orderDetail/addOrderDetail")
	public OrderDetail addOrderDetail(@RequestBody OrderDetail orderDetail){
		return service.saveOrderDetail(orderDetail);
	}
	@GetMapping("orderDetail/orderDetailById/{id}")
	public OrderDetail findOrderDetailById(@PathVariable int id) {
		return service.getOrderDetailById(id);
	}
}
