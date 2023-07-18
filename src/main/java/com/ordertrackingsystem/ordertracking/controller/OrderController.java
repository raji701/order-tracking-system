package com.ordertrackingsystem.ordertracking.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ordertrackingsystem.ordertracking.dto.OrderRequestDto;
import com.ordertrackingsystem.ordertracking.dto.OrderItemDto;
import com.ordertrackingsystem.ordertracking.entities.Customer;
import com.ordertrackingsystem.ordertracking.entities.Order;
import com.ordertrackingsystem.ordertracking.entities.OrderItem;
import com.ordertrackingsystem.ordertracking.entities.OrderItemCK;
import com.ordertrackingsystem.ordertracking.repository.OrderItemRepo;
import com.ordertrackingsystem.ordertracking.repository.OrderRepo;
import com.ordertrackingsystem.ordertracking.repository.ProductRepo;

@RestController
public class OrderController {

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private OrderItemRepo orderItemRepo;

	// 2.List of Orders by customer id
	@GetMapping("/orders/customerid")
	public List<Order> ordersOfACustomer(@RequestParam("id") int id) {
		try {
			return orderRepo.findOrdersByCustomerId(id);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "there are no orders on given customerId ");
		}
	}

	// 4.List of orders after a given date
	@GetMapping("/orders/date")
	public List<Order> ordersAfterDate(@RequestParam("value") LocalDate date) {
		try {
			String dat = date.toString();
			LocalDate dateFormatt = LocalDate.parse(dat, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			return orderRepo.findByOrderDateAfter(date);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "there are no orders after the given date ");
		}
	}

	// 5.List of orders with given status
	@GetMapping("orders/status/{status}")
	public List<Order> ordersWithStatus(@PathVariable("status") char status) {
		try {
			return orderRepo.findByStatusEquals(status);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "there are no orders on given status ");
		}
	}

	// 9.Add a new Order by taking customer id ,list of products and quantities
	// orders in the order
	@PostMapping("/neworder")
	public Order createOrder(@RequestBody OrderRequestDto orderRequestDto) {
		try {

			int customerId = orderRequestDto.getCustomerId();
			List<OrderItemDto> orderItems = orderRequestDto.getOrderItems();

			// create instance for order entity
			Order order = new Order();
			// set values to the instance
			Customer customer = new Customer();
			customer.setCustomerId(customerId);
			order.setCustomer(customer);
			order.setStatus('n');
			LocalDate date = LocalDate.now();
			order.setOrderDate(date);

			// save instance of order entity
			orderRepo.save(order);
			// get new order id
			int id = orderRepo.max();

			for (OrderItemDto item : orderItems) {

				// create instance for order entity
				OrderItem orderItem = new OrderItem();
				// set values to the instance
				OrderItemCK ck = new OrderItemCK();
				ck.setOrderId(id);
				ck.setProductId(item.getProductId());
				orderItem.setOrderitems_cpk(ck);
				orderItem.setQuantity(item.getQuantity());
				orderItem.setPrice(productRepo.priceOfProduct(item.getProductId()) * 0.90);
				// save instance of orderItem entity
				orderItemRepo.save(orderItem);
			}

			return order;
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid data!");
		}
	}

	// 10.Provide all details of an order for the given order id
	@GetMapping("/orders/{id}")
	public Order OrderDetails(@PathVariable("id") int id) {
		try {
			return orderRepo.findById(id).get();
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "there is no order with the given orderId ");
		}

	}

}
