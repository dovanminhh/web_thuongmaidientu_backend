package com.app.reposity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	Customer findByEmail(String email);
}
