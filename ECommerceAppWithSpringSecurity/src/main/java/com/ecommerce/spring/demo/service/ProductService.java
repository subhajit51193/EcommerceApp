package com.ecommerce.spring.demo.service;

import com.ecommerce.spring.demo.exceptions.UserException;
import com.ecommerce.spring.demo.model.Product;

public interface ProductService {


	public Product addProduct(Product product)throws UserException;
}
