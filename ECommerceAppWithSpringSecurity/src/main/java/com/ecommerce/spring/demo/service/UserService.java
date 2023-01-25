package com.ecommerce.spring.demo.service;

import java.util.List;

import com.ecommerce.spring.demo.exceptions.ProductException;
import com.ecommerce.spring.demo.exceptions.UserException;
import com.ecommerce.spring.demo.model.Cart;
import com.ecommerce.spring.demo.model.Product;
import com.ecommerce.spring.demo.model.Review;
import com.ecommerce.spring.demo.model.User;

public interface UserService {

	public String  addToCart(Long productId,Long quantity)throws UserException,ProductException;
	
	public List<Cart> getItemsOfCart() throws UserException;
	
	public String removefromcart(Long productId) throws UserException,ProductException;
	
	public List<Product> getAllProducts();
	
	public Review giveReview(Long productId,Review review)throws UserException,ProductException;
	
	public List<Review> getReviewsByUser() throws UserException;
}
