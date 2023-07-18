package com.ordertrackingsystem.ordertracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ordertrackingsystem.ordertracking.entities.Product;
import com.ordertrackingsystem.ordertracking.repository.ProductRepo;

@RestController
public class ProductController {

	@Autowired
	private ProductRepo productRepo;

	
	//2.List of products by pagination
	@GetMapping("/products/page")
	public List<Product> getEntities(@RequestParam("number")Integer number,@RequestParam("size") Integer size) {
		var products = productRepo.findAll(PageRequest.of(number, size));
		return products.getContent();
	}

	//7.List of products where name matches the given string
	@GetMapping("/products/match/{string}")
	public List<Product> listOfProductsMatchesWithName(@PathVariable("string") String productName) {
		try {
			return productRepo.productByProductName(productName);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"There are no products containing the given string ");
		}
	}
	
	@PutMapping("price/update/{price}/{id}")
	public String updatePrice(@PathVariable("price") double price ,@PathVariable("id") Integer id)
	{
		 productRepo.updatedProduct(price, id);
		 
		 return productRepo.findById(id).get().getPrice() + " is the updated price.";
	}
}
