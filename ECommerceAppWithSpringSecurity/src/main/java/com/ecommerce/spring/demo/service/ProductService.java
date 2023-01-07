package com.ecommerce.spring.demo.service;

import com.ecommerce.spring.demo.exceptions.ProductException;
import com.ecommerce.spring.demo.exceptions.UserException;
import com.ecommerce.spring.demo.model.Product;

public interface ProductService {


	public Product addProduct(Product product)throws UserException;
	
	public String deleteProduct(Long productId)throws ProductException,UserException;
	
	public String updateProduct(Product product)throws UserException,ProductException;
}
