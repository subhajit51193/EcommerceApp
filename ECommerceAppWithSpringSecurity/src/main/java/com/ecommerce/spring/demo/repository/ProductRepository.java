package com.ecommerce.spring.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.spring.demo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query("FROM Product p ORDER BY p.price")
	public List<Product> sortByPrice();
}
