package com.ordertrackingsystem.ordertracking.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ordertrackingsystem.ordertracking.entities.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

	@Query("select o.orderId ,o.orderDate, o.status ,o.deliveryDate from Order o  where o.orderId = :id")
	List<Object[]> ordersByOrderId(@Param("id") Integer id);

	@Query("select max(o.orderId) from Order o")
	int max();

	// 4
	List<Order> findByOrderDateAfter(LocalDate date);

	// 5
	List<Order> findByStatusEquals(char status);

	// 3
	@Query("from Order o where o.customer.customerId =:id")
	List<Order> findOrdersByCustomerId(int id);

}
