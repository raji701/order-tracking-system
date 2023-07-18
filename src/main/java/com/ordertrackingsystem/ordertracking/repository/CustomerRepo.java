package com.ordertrackingsystem.ordertracking.repository;



import java.util.LinkedHashSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ordertrackingsystem.ordertracking.entities.Customer;



public interface CustomerRepo extends JpaRepository<Customer,Integer> {
	
	@Query("SELECT  oi.product.productName FROM Customer c JOIN c.orders o JOIN o.orderItems oi WHERE c.customerId = :id")
	LinkedHashSet<String > customerPurchases(@Param("id") Integer id);

	
}
