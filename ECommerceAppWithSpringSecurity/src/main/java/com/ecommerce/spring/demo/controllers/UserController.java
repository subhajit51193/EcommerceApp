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
import com.ecommerce.spring.demo.model.Cart;
import com.ecommerce.spring.demo.model.Product;
import com.ecommerce.spring.demo.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/addTocart/{productId}/{userId}/{quantity}")
	public ResponseEntity<String> addToCart(@PathVariable("productId") Long productId,@PathVariable("userId") Long userId,@PathVariable("quantity") Long quantity) throws UserException, ProductException{
		String res = userService.addToCart(productId, userId, quantity);
		return new ResponseEntity<String>(res,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/cartItems")
	public ResponseEntity<List<Cart>> getItemsOfCart() throws UserException{
		List<Cart> list = userService.getItemsOfCart();
		return new ResponseEntity<List<Cart>>(list,HttpStatus.ACCEPTED);
	}
	
}
