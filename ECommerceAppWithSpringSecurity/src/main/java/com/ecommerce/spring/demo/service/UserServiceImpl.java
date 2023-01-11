package com.ecommerce.spring.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ecommerce.spring.demo.exceptions.ProductException;
import com.ecommerce.spring.demo.exceptions.UserException;
import com.ecommerce.spring.demo.model.Product;
import com.ecommerce.spring.demo.model.User;
import com.ecommerce.spring.demo.repository.ProductRepository;
import com.ecommerce.spring.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> addToCart(Long productId) throws UserException, ProductException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			Optional<User> opt = userRepository.findByUsername(currentUserName);
			if (opt.isEmpty()) {
				throw new UserException("User not found please try again...");
			}
			else {
				
				User user = opt.get();
				Optional<Product> opt2 = productRepository.findById(productId);
				if (opt2.isEmpty()) {
					throw new ProductException("Product not found or may have been sold...");
				}
				else {
					Product product = opt2.get();
					if (user.getCart().contains(product)) {
						throw new ProductException("Product already added to cart...");
					}
					else {
						user.getCart().add(product);
						return user.getCart();
						

					}
									}
			}
		}
		else {
			throw new UserException("Please Login and try again!!!");
		}
	}

	@Override
	public String deleteFromCart(Long productId) throws UserException, ProductException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			Optional<User> opt = userRepository.findByUsername(currentUserName);
			if (opt.isEmpty()) {
				throw new UserException("User not found please try again...");
			}
			else {
				
				User user = opt.get();
				Optional<Product> opt2 = productRepository.findById(productId);
				if (opt2.isEmpty()) {
					throw new ProductException("Product not found or may have been removed already...");
				}
				else {
					Product product = opt2.get();
					user.getCart().remove(product);
					return "Item removed from cart...";
					
				}
			}
		}
		else {
			throw new UserException("Please Login and try again!!!");
		}
	}

	
}
