package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Customer;
import com.app.reposity.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repository;
	
	public List<Customer> getCustomer(){
		return repository.findAll();
	}
	
	public Customer addCustomer(Customer customer) {
		return repository.save(customer);
	}
	public Customer getCustomerById(int id) {
		return repository.findById(id).orElse(null);
	}
	public void deleteCustomer(int id) {
		repository.deleteById(id);
	}
	
}
