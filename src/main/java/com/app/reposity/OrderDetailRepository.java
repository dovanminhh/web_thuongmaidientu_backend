package com.app.reposity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{
	
}
