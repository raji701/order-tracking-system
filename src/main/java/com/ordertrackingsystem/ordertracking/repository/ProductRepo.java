package com.ordertrackingsystem.ordertracking.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ordertrackingsystem.ordertracking.entities.Product;

import jakarta.transaction.Transactional;

public interface ProductRepo extends JpaRepository<Product,Integer>{
	
	//7
	@Query("from Product p where p.productName like %:substr%")
	List<Product> productByProductName(@Param("substr")String substr);
	
	
	@Query("select p.price from Product p where p.productId = :id")
	Double  priceOfProduct(@Param("id")Integer id);
	
	@Transactional
	@Modifying
	@Query("update Product p set p.price = :newprice where p.productId = :id")
	void updatedProduct(@Param("newprice")Double newprice,@Param("id")Integer id);
}
