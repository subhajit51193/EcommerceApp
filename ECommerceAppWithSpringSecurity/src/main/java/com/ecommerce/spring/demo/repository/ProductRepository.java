package com.ecommerce.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.spring.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
