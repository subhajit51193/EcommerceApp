package com.ecommerce.spring.demo.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ecommerce.spring.demo.exceptions.ProductException;
import com.ecommerce.spring.demo.exceptions.UserException;
import com.ecommerce.spring.demo.model.ERole;
import com.ecommerce.spring.demo.model.Product;
import com.ecommerce.spring.demo.model.Role;
import com.ecommerce.spring.demo.model.User;
import com.ecommerce.spring.demo.repository.ProductRepository;
import com.ecommerce.spring.demo.repository.UserRepository;
import com.ecommerce.spring.demo.security.jwt.JwtUtils;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private JwtUtils jwtUtils;

	@Override
	public Product addProduct(Product product) throws UserException {
		// TODO Auto-generated method stub
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			Optional<User> opt = userRepository.findByUsername(currentUserName);
			if (opt.isEmpty()) {
				throw new UserException("User not found please try again...");
			}
			else {
				
				Product addedProduct = productRepository.save(product);
				return addedProduct;
			}
		}
		else {
			throw new UserException("Please Login and try again!!!");
		}
		
	}

	@Override
	public String deleteProduct(Long productId) throws ProductException,UserException {
		// TODO Auto-generated method stub
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
					throw new ProductException("Product ID not found please try again with valid id...");
				}
				else {
					Product foundProduct = opt2.get();
					productRepository.delete(foundProduct);
					return user.getUsername()+" ypur intended product :"+foundProduct.getProductName()+" has been deleted";
				}
			}
		}
		else {
			throw new UserException("Please Login and try again!!!");
		}
	}

	@Override
	public String updateProduct(Product product) throws UserException, ProductException {
		// TODO Auto-generated method stub
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			Optional<User> opt = userRepository.findByUsername(currentUserName);
			if (opt.isEmpty()) {
				throw new UserException("User not found please try again...");
			}
			else {
				User user = opt.get();
				Optional<Product> opt2 = productRepository.findById(product.getProductId());
				if (opt2.isEmpty()) {
					throw new ProductException("No product foudn with id :"+product.getProductId()+" please try again with valid details");
				}
				else {
					Product updatedProduct = productRepository.save(product);
					return user.getUsername()+" your intended product  has been updated new product is :"+updatedProduct;
				}
				
			}
		}
		else {
			throw new UserException("Please Login and try again!!!");
		}
		
	}

	
}
