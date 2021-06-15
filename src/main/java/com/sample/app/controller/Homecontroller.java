package com.sample.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.app.entity.Customer;
import com.sample.app.repo.CustomerRepository;

@RestController
public class Homecontroller {
	
	
	private final Logger log=LoggerFactory.getLogger(this.getClass());
	@Autowired
	CustomerRepository usrRepo;
	
	@GetMapping("/api/checkservice")
	public String heartbeat() {
		return "Alive";
	}
	
	@GetMapping("/api/addition")
	public String addValues(@RequestParam int a,@RequestParam int b) {
		log.debug("addition of "+a+" and "+b+" is = "+(a+b));
		return "addition of "+a+" and "+b+" is = "+(a+b);

	}
	
	@GetMapping("/api/subtraction")
	public String subValues(@RequestParam int a,@RequestParam int b) {
		log.debug("subtraction of "+a+" and "+b+" is = "+(a-b));
		return "subtraction of "+a+" and "+b+" is = "+(a-b);
	}
	
	@PostMapping("/api/register")
	public String addUser(@RequestBody Customer usr) {
		usrRepo.save(usr);
		return "added successfully";
		
	}

}
