package com.ecommerce.spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.spring.demo.exceptions.UserException;
import com.ecommerce.spring.demo.model.Product;
import com.ecommerce.spring.demo.service.ProductService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(Product product) throws UserException{
		Product addedProduct=productService.addProduct(product);
		return new ResponseEntity<Product>(addedProduct,HttpStatus.CREATED);
	}
}
