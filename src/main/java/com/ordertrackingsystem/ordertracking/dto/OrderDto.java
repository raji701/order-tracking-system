package com.ordertrackingsystem.ordertracking.dto;

import java.time.LocalDate;

public class OrderDto {

	
	private int orderId ;
	
	private LocalDate orderDate;
	
	private Character status;
	
	

	public OrderDto(int orderId, LocalDate orderDate, Character status) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.status = status;
		
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}


	
	
}
