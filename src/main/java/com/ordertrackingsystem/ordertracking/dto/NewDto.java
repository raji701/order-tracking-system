package com.ordertrackingsystem.ordertracking.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class NewDto {
	
	private String email;
	
	private String customerName;
	
	private List<OrderDto> orderList;
	


//	public NewDto(String email, String customerName, int orderId,LocalDate orderDate ,Character status) {
//		super();
//		this.email = email;
//		this.customerName = customerName;
//		OrderDto orderDto = new OrderDto( orderId,orderDate,status);
//		this.orderList = new ArrayList<>();
//		this.orderList.add(orderDto);
//	}



	

	public NewDto(String email, String customerName, List<OrderDto> orderList) {
	super();
	this.email = email;
	this.customerName = customerName;
	this.orderList = orderList;
}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public List<OrderDto> getOrderList() {
		return orderList;
	}



	public void setOrderList(List<OrderDto> orderList) {
		this.orderList = orderList;
	}
	

	
	

}
