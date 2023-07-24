package com.ordertrackingsystem.ordertracking.services;

import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordertrackingsystem.ordertracking.entities.Customer;
import com.ordertrackingsystem.ordertracking.repository.CustomerRepo;

@Service
public class CustomerService {
   
    @Autowired
    CustomerRepo customerRepo ;


    public List<Customer> getAllCustomers()
    {
       return customerRepo.findAll();
    }

    public LinkedHashSet<String> purchases(Integer id) {
		return customerRepo.customerPurchases(id);
	}

    public String updateProfile(int id , Customer customer)
	{
		String email = customer.getEmail(); 
		customerRepo.updateEmail(email ,id);
		return "updated successfully";
	}

    public String updateName(int id ,Customer customer)
	{
		String name = customer.getCustomerName(); 
		customerRepo.updateName(name ,id);
		return "updated successfully";
	}
}
