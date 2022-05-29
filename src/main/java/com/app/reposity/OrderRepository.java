package com.app.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	@Query(nativeQuery = true, value = "select * from or_der o where o.customer_id = :customer_id")
	List<Order> findOrderByCustomer(@Param("customer_id") int customer_id);
}
