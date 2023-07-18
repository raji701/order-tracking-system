package com.ordertrackingsystem.ordertracking.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ordertrackingsystem.ordertracking.entities.Customer;
import com.ordertrackingsystem.ordertracking.entities.Order;
import com.ordertrackingsystem.ordertracking.entities.OrderItem;
import com.ordertrackingsystem.ordertracking.entities.OrderItemCK;
import com.ordertrackingsystem.ordertracking.entities.Product;
import com.ordertrackingsystem.ordertracking.repository.CustomerRepo;
import com.ordertrackingsystem.ordertracking.repository.OrderItemRepo;
import com.ordertrackingsystem.ordertracking.repository.OrderRepo;
import com.ordertrackingsystem.ordertracking.repository.ProductRepo;

@RestController
public class ExtraController {
	
	// auto wiring

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private OrderItemRepo orderItemRepo;
	// 1
	@GetMapping("/customers/all")
	public List<Customer> listOfCustomers() {
		return customerRepo.findAll();
	}
	
	@GetMapping("/products")
	public List<Product> listOfProducts() {
		return productRepo.findAll();
	}
	
	@GetMapping("/orders/all")
	public List<Order> allOrders()
	{
		return orderRepo.findAll();
	}
	
	@GetMapping("/orderitems/all")
	public List<OrderItem> allOrderItems()
	{
		return orderItemRepo.findAll();
	}
	
	
	
	@PostMapping("/newpost")
	public Order addNewOrders(@RequestParam("customerid") Integer customerid,
			@RequestParam("productid") List<Integer> productid, @RequestParam("quantity") List<Integer> quantity) {

		try {
			Customer customer = customerRepo.findById(customerid).get();

			Order order = new Order();
			order.setCustomer(customer);

			LocalDate date = LocalDate.now();
			order.setOrderDate(date);

			order.setStatus('n');

			orderRepo.save(order);
			int id = orderRepo.max();
			List<OrderItem> loi = new ArrayList<>();

			for (int i = 0; i < productid.size(); i++) {
				OrderItem oi = new OrderItem();
				OrderItemCK ck = new OrderItemCK();
				ck.setOrderId(id);
				ck.setProductId(productid.get(i));
				oi.setOrderitems_cpk(ck);
				oi.setQuantity(quantity.get(i));
				Double price = productRepo.priceOfProduct(productid.get(i));
				oi.setPrice(quantity.get(i) * price);

				loi.add(oi);
			}
			order.setOrderItems(loi);

			orderItemRepo.saveAll(loi);

			return order;
		} catch (Exception ex) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invaliddata !");
		}

	}
}
