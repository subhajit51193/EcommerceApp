package com.ecommerce.spring.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.spring.demo.exceptions.ProductException;
import com.ecommerce.spring.demo.exceptions.UserException;
import com.ecommerce.spring.demo.model.Product;
import com.ecommerce.spring.demo.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/additem/{productId}")
	public ResponseEntity<List<Product>> addToCart(@PathVariable("productId") Long productId) throws UserException, ProductException{
		List<Product> cart = userService.addToCart(productId);
		return new ResponseEntity<List<Product>>(cart,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/removeitem/{productId}")
	public ResponseEntity<String> deleteFromCartr(@PathVariable("productId") Long productId) throws UserException, ProductException{
		String res = userService.deleteFromCart(productId);
		return new ResponseEntity<String>(res,HttpStatus.ACCEPTED);
	}
}
