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

import com.ordertrackingsystem.ordertracking.dto.NewDto;
import com.ordertrackingsystem.ordertracking.entities.Customer;
import com.ordertrackingsystem.ordertracking.services.CustomerService;

@RestController
public class CustomerController {



	@Autowired
	private CustomerService cs;

	// 1.List of Customers
	@GetMapping("/customers")
	public List<Customer> listOfCustomers() {
		return cs.getAllCustomers();
	}

	@GetMapping("/customer/purchases/{id}")
	public LinkedHashSet<String> purchases(@PathVariable ("id") Integer id) {
		return cs.purchases(id);
	}

	@PutMapping("/customer/update/{id}")
	public String updateProfile(@PathVariable("id")int id ,@RequestBody Customer customer)
	{
		return cs.updateProfile(id, customer); 
	}
	
	@PatchMapping("/customer/name/{id}")
	public String updateName1(@PathVariable("id")int id ,@RequestBody Customer customer)
	{
		return cs.updateName(id ,customer);
	}
	
	@GetMapping("/customer/new/{id}")
	public  NewDto listOfDetails(@PathVariable("id")int id)
	{
		return cs.getCustomerDetailsWithOrders(id);
		//return cs.aList(id);
	}
}
