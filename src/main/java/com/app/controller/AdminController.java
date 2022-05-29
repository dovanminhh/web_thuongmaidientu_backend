package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Admin;
import com.app.reposity.AdminRepository;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	@Autowired
	private AdminRepository repository;
	
	@RequestMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody Admin adminData){
		
		Admin admin = repository.findByEmail(adminData.getEmail());
		
		if(admin.getPassword().equals(adminData.getPassword()))
			return ResponseEntity.ok(admin);
		
		return (ResponseEntity<?>) ResponseEntity.internalServerError();
	}
	
}
