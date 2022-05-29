package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.OrderDetail;
import com.app.reposity.OrderDetailRepository;

@Service
public class OrderDetailService {
	@Autowired
	private OrderDetailRepository repository;
	
	public List<OrderDetail> listOrderDetail(){
		return (List<OrderDetail>) repository.findAll();
	}
	
	public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
		return repository.save(orderDetail);
	}

	public OrderDetail getOrderDetailById(int id) {
		return repository.findById(id).orElse(null);
	}
}
