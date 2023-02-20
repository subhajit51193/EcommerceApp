package com.ecommerce.spring.demo.service;

import java.util.List;

import com.ecommerce.spring.demo.exceptions.OrderException;
import com.ecommerce.spring.demo.exceptions.ProductException;
import com.ecommerce.spring.demo.exceptions.UserException;
import com.ecommerce.spring.demo.exceptions.WalletException;
import com.ecommerce.spring.demo.model.Cart;
import com.ecommerce.spring.demo.model.Order;
import com.ecommerce.spring.demo.model.Product;
import com.ecommerce.spring.demo.model.Review;
import com.ecommerce.spring.demo.model.User;
import com.ecommerce.spring.demo.model.Wallet;

public interface UserService {

	public String  addToCart(Long productId,Long quantity)throws UserException,ProductException;
	
	public List<Cart> getItemsOfCart() throws UserException;
	
	public String removefromcart(Long productId) throws UserException,ProductException;
	
	
	
	public Review giveReview(Long productId,Review review)throws UserException,ProductException;
	
	public List<Review> getReviewsByUser() throws UserException;
	
	public List<Product> sortProductByPrice();
	
	public Order purchaseItems() throws UserException, WalletException, ProductException;
	
	public Double checkWalletBalance()throws UserException,WalletException;
	
	public Wallet addBalanceToWallet(Double amount)throws UserException;
	
	public Product getProductDetails(Long productId)throws ProductException;
	
	public Order getOrderDetails(Long orderId)throws UserException,OrderException;
	
	public List<Order> getOrderHistory()throws UserException,OrderException;;
	
	public String welcomeMessage();
}
