package com.ordertrackingsystem.ordertracking.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ordertrackingsystem.ordertracking.dto.ItemDto;
import com.ordertrackingsystem.ordertracking.repository.OrderItemRepo;

@Service
public class OrderItemService {
	
	
	@Autowired
	private OrderItemRepo orderItemRepo ;
	
	public List<ItemDto> getOrderItems(int id)
	{
		return orderItemRepo.orderItemsByProduct(id);
	}
}
