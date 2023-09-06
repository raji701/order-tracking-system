package com.ordertrackingsystem.ordertracking.services;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordertrackingsystem.ordertracking.dto.NewDto;
import com.ordertrackingsystem.ordertracking.dto.OrderDto;
import com.ordertrackingsystem.ordertracking.entities.Customer;
import com.ordertrackingsystem.ordertracking.repository.CustomerRepo;

@Service
public class CustomerService {
   
    @Autowired
    private CustomerRepo customerRepo ;


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
    
    public List<NewDto> aList(int id)
    {
    	return customerRepo.customerDetailsById(id);
    }
    
    public NewDto getCustomerDetailsWithOrders(int customerId) {
        Optional<Customer> customerOptional = customerRepo.findById(customerId);
        
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            List<OrderDto> orderDTOList = customer.getOrders().stream()
                .map(order -> new OrderDto(order.getOrderId(), order.getOrderDate(), order.getStatus()))
                .collect(Collectors.toList());
            return new NewDto(customer.getEmail(), customer.getCustomerName(), orderDTOList);
        } else {
            // Handle the case where the customer ID is not found
            // You can throw an exception or return null, depending on your requirement.
            return null;
        }
    }
}
