package com.ordertrackingsystem.ordertracking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItem {

	// -----------------data members---------------------
	@JsonIgnore
	@EmbeddedId
	private OrderItemCK orderitems_cpk;
	
	@Column(name = "ref_order_id",insertable =false,updatable=false)
	private int orderId;


	@Column(name = "ref_product_id",insertable =false,updatable=false)
	private int productId;

	@Column(name = "qty_of_items")
	private Integer quantity;

	@Column(name = "updated_price")
	private Double price;

	// mapped to order_id column in orders table by ref_order_id column in
	// order_items table to resemble the relation between orders and order_items
	// tables in database
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("ref_order_id")
	@JoinColumn(name = "ref_order_id", referencedColumnName = "order_id")
	private Order order;

	// mapped to product_id column in orders table by ref_product_id column in
	// order_items table to resemble the relation between products and order_items
	// tables in database
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("ref_product_id")
	@JoinColumn(name = "ref_product_id", referencedColumnName = "product_id")
	private Product product;

	// -----------------getters and setters---------------

	public OrderItemCK getOrderitems_cpk() {
		return orderitems_cpk;
	}

	public void setOrderitems_cpk(OrderItemCK orderitems_cpk) {
		this.orderitems_cpk = orderitems_cpk;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getProductId() {
		return productId;
	}



}
