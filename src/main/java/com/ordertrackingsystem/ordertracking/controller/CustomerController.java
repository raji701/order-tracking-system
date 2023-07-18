package com.ordertrackingsystem.ordertracking.controller;

import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ordertrackingsystem.ordertracking.entities.Customer;
import com.ordertrackingsystem.ordertracking.repository.CustomerRepo;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepo customerRepo;

	// 1.List of Customers
	@GetMapping("/customers")
	public List<Customer> listOfCustomers() {
		return customerRepo.findAll();
	}
	
	@GetMapping("/customer/purchases/{id}")
	public LinkedHashSet<String> purchases(@PathVariable ("id") Integer id) {
		return customerRepo.customerPurchases(id);
	}

}
