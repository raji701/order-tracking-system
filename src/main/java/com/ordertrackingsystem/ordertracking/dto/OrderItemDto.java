package com.ordertrackingsystem.ordertracking.dto;

public class OrderItemDto {
	private int productId;

	private int quantity;

	public OrderItemDto() {
	}

	public OrderItemDto(int id, int quantity) {
		this.productId = id;
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductDto{" + "id=" + productId + ", quantity=" + quantity + '}';
	}

}
