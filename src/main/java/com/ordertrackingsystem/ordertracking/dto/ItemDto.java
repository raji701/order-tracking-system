package com.ordertrackingsystem.ordertracking.dto;

import java.time.LocalDate;

public class ItemDto {
	
	private String customerName;
	
	private String productName;
	
	private Double price;
	
	private Integer quantity;
	
	private LocalDate orderDate ;
	
	

	public ItemDto() {
		super();
		
	}

	public ItemDto(String customerName,String productName,Double price,Integer quantity, LocalDate orderDate) {
		super();
		this.productName = productName;
		this.customerName = customerName;
		this.price = price;
		this.quantity = quantity ;
		this.orderDate = orderDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

}
