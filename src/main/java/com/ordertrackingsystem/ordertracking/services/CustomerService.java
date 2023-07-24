package com.ordertrackingsystem.ordertracking.services;

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
}
