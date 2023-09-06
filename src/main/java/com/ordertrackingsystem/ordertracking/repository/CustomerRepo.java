package com.ordertrackingsystem.ordertracking.repository;


import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ordertrackingsystem.ordertracking.dto.NewDto;
import com.ordertrackingsystem.ordertracking.entities.Customer;

import jakarta.transaction.Transactional;




public interface CustomerRepo extends JpaRepository<Customer,Integer> {
	
	@Query("SELECT  oi.product.productName FROM Customer c JOIN c.orders o JOIN o.orderItems oi WHERE c.customerId = :id")
	LinkedHashSet<String > customerPurchases(@Param("id") Integer id);

	@Modifying
	@Transactional
	@Query("update Customer c set c.email = :email where c.customerId =:id")
	void updateEmail(@Param("email")String email,@Param("id")int id);
	
	@Modifying
	@Transactional
	@Query("update Customer c set c.customerName = :name where c.customerId =:id")
	void updateName(@Param("name")String name,@Param("id")int id);
	
	
	   //new

//	   @Query("SELECT NEW com.ordertrackingsystem.ordertracking.dto.NewDto(c.email, c.customerName, o.orderId, o.orderDate, o.status) " +
//	           "FROM Customer c " +
//	           "LEFT JOIN c.orders o " +
//	           "WHERE c.customerId = :customerId")
	
	 @Query("SELECT NEW com.ordertrackingsystem.ordertracking.dto.NewDto(c.email, c.customerName, " +
	           "NEW com.ordertrackingsystem.ordertracking.dto.OrderDto(o.orderId, o.orderDate, o.status)) " +
	           "FROM Customer c " +
	           "LEFT JOIN c.orders o " +
	           "WHERE c.customerId = :customerId")
		List<NewDto> customerDetailsById(@Param("customerId")int customerId);
}
