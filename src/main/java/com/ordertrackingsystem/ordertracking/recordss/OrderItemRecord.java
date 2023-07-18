package com.ordertrackingsystem.ordertracking.recordss;

import java.time.LocalDate;

public record OrderItemRecord(String ProductName,String CustomerName,int quantity,int price,LocalDate date) {

	@Override
	public String toString() {
		return "OrderItemRecord [ProductName=" + ProductName + ", CustomerName=" + CustomerName + ", quantity="
				+ quantity + ", price=" + price + ", date=" + date + "]";
	}

	

}
