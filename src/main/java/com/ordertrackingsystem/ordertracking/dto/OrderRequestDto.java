package com.ordertrackingsystem.ordertracking.dto;

import java.util.List;

public class OrderRequestDto {
	
	private int customerId;
	
	private List<OrderItemDto> oredrItems;

	public OrderRequestDto() {
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public List<OrderItemDto> getOrderItems() {
		return oredrItems;
	}

	public void setOrderItems(List<OrderItemDto> products) {
		this.oredrItems = products;
	}

	@Override
	public String toString() {
		return "OrderRequestDto{" + "customerId=" + customerId + ", products=" + oredrItems + '}';
	}
}
