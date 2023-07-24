package com.ordertrackingsystem.ordertracking.controller;

import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ordertrackingsystem.ordertracking.entities.Customer;
import com.ordertrackingsystem.ordertracking.repository.CustomerRepo;
import com.ordertrackingsystem.ordertracking.services.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private CustomerService cs;

	// 1.List of Customers
	@GetMapping("/customers")
	public List<Customer> listOfCustomers() {
		return cs.getAllCustomers();
	}
	
	@GetMapping("/customer/purchases/{id}")
	public LinkedHashSet<String> purchases(@PathVariable ("id") Integer id) {
		return customerRepo.customerPurchases(id);
	}

	@PutMapping("/customer/update/{id}")
	public String updateProfile(@PathVariable("id")int id ,@RequestBody Customer customer)
	{
		String email = customer.getEmail(); 
		customerRepo.updateEmail(email ,id);
		return "updated successfully";
	}
	
	@PatchMapping("/customer/name/{id}")
	public String updateName(@PathVariable("id")int id ,@RequestBody Customer customer)
	{
		String name = customer.getCustomerName(); 
		customerRepo.updateName(name ,id);
		return "updated successfully";
	}
}
