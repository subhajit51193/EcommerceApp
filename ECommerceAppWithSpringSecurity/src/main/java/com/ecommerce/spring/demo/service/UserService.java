package com.ecommerce.spring.demo.service;

import java.util.List;

import com.ecommerce.spring.demo.exceptions.ProductException;
import com.ecommerce.spring.demo.exceptions.UserException;
import com.ecommerce.spring.demo.model.Product;

public interface UserService {

	public List<Product> addToCart(Long productId)throws UserException,ProductException;
	
	public String deleteFromCart(Long productId)throws UserException,ProductException;
}
