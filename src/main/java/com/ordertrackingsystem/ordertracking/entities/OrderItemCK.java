package com.ordertrackingsystem.ordertracking.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

//creating composite primary key OrderItems
@Embeddable
public class OrderItemCK implements Serializable {

	// -----------data members------------------
	@Column(name = "ref_order_id")
	private int orderId;


	@Column(name = "ref_product_id")
	private int productId;

	// ----default constructor----
	public OrderItemCK() {
		super();
	}
	
	public OrderItemCK(int orderId, int productId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
	}


	// ------------getters setters----------------
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productid) {
		this.productId = productid;
	}

	// overriding hashcode method from Object class
	@Override
	public int hashCode() {
		return Objects.hash(orderId, productId);
	}

	// overriding equals method from Object class
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemCK other = (OrderItemCK) obj;
		return orderId == other.orderId && productId == other.productId;
	}

}
