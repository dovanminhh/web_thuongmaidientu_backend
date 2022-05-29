package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Customer;
import com.app.reposity.CustomerRepository;
import com.app.service.CustomerService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/")
public class CustomerController {
	@Autowired
	private CustomerService service;
	
	@Autowired
	private CustomerRepository repository;
	
	@RequestMapping("login")
	public ResponseEntity<?> loginCustomer(@RequestBody Customer customerData){
		Customer customer = repository.findByEmail(customerData.getEmail());
		if(customer.getPassword().equals(customerData.getPassword()))
			return ResponseEntity.ok(customer);
		return (ResponseEntity<?>) ResponseEntity.internalServerError();
	}
	@GetMapping("customer")
	public List<Customer> findAllCustomer(){
		return service.getCustomer();
	}
	
	@RequestMapping(value = "addRegister", method = RequestMethod.POST, consumes={"application/json"})
	public Customer addCustomer(@RequestBody Customer customer) {
			return service.addCustomer(customer);
	}
	
	@GetMapping("customer/getCustomerById/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return service.getCustomerById(id);
	}
	
	@DeleteMapping("customer/delete/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
    	service.deleteCustomer(id);
    	 return new ResponseEntity<>(HttpStatus.OK);
    }
}
