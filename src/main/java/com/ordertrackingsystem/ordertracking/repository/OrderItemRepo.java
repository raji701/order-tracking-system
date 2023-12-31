package com.ordertrackingsystem.ordertracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ordertrackingsystem.ordertracking.entities.OrderItem;
import com.ordertrackingsystem.ordertracking.entities.OrderItemCK;
import com.ordertrackingsystem.ordertracking.recordss.OrderItemRecord;

public interface OrderItemRepo extends JpaRepository<OrderItem, OrderItemCK> {
	// 6
	@Query("select oi.product.productName, oi.quantity,oi.price from OrderItem oi where oi.order.orderId = :id")
	List<Object[]> orderItemsByOrder(@Param("id") int id);

	// 8
	@Query("select new com.ordertrackingsystem.ordertracking.recordss.OrderItemRecord(oi.product.productName, oi.order.customer.customerName, oi.quantity, oi.price, oi.order.orderDate) from OrderItem oi where oi.product.productId = :id")
	List<OrderItemRecord> orderItemsByProduct(@Param("id") int id);

	
}
