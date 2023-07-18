package com.ordertrackingsystem.ordertracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ordertrackingsystem.ordertracking.recordss.OrderItemRecord;
import com.ordertrackingsystem.ordertracking.repository.OrderItemRepo;

@RestController
public class OrderItemController {

	@Autowired
	private OrderItemRepo orderItemRepo;

	// 6.List of order items in a given order
	@GetMapping("/orderitems/order/{id}")
	public List<Object[]> orderItemsInOrder(@PathVariable("id") int orderId) {
		try {
			return orderItemRepo.orderItemsByOrder(orderId);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "there is no  order with the given orderid ");
		}
	}

	// 8.List of Order items on given product
	@GetMapping("/orderitems/product/{id}")
	public List<OrderItemRecord> orderItemsWithProduct(@PathVariable("id") int productId) {
		try {
			return orderItemRepo.orderItemsByProduct(productId);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "there is no  order with the given productid ");
		}
	}
	
	

}
