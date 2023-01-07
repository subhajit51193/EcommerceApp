package com.ecommerce.spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.spring.demo.exceptions.ProductException;
import com.ecommerce.spring.demo.exceptions.UserException;
import com.ecommerce.spring.demo.model.Product;
import com.ecommerce.spring.demo.service.ProductService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	ProductService productService;
	
	@CrossOrigin
	@PostMapping("/addProduct")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws UserException{
		Product addedProduct=productService.addProduct(product);
		return new ResponseEntity<Product>(addedProduct,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") Long ProductId) throws ProductException, UserException{
		String res = productService.deleteProduct(ProductId);
		return new ResponseEntity<String>(res,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateProduct")
	public ResponseEntity<String> updateProduct(@RequestBody Product product) throws UserException, ProductException{
		String res = productService.updateProduct(product);
		return new ResponseEntity<String>(res,HttpStatus.ACCEPTED);
	}
}
