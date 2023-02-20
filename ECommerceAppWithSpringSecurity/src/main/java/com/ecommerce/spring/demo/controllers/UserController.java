package com.ecommerce.spring.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.spring.demo.exceptions.OrderException;
import com.ecommerce.spring.demo.exceptions.ProductException;
import com.ecommerce.spring.demo.exceptions.UserException;
import com.ecommerce.spring.demo.exceptions.WalletException;
import com.ecommerce.spring.demo.model.Cart;
import com.ecommerce.spring.demo.model.Order;
import com.ecommerce.spring.demo.model.Product;
import com.ecommerce.spring.demo.model.Review;
import com.ecommerce.spring.demo.model.Wallet;
import com.ecommerce.spring.demo.service.ProductService;
import com.ecommerce.spring.demo.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/addTocart/{productId}/{quantity}")
	public ResponseEntity<String> addToCart(@PathVariable("productId") Long productId,@PathVariable("quantity") Long quantity) throws UserException, ProductException{
		String res = userService.addToCart(productId, quantity);
		return new ResponseEntity<String>(res,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/cartItems")
	public ResponseEntity<List<Cart>> getItemsOfCart() throws UserException{
		List<Cart> list = userService.getItemsOfCart();
		return new ResponseEntity<List<Cart>>(list,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/remove/{productId}")
	public ResponseEntity<String> removeFromCart(@PathVariable("productId") Long productId) throws UserException, ProductException{
		String res = userService.removefromcart(productId);
		return new ResponseEntity<String>(res,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/allProducts")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(products,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/giveReview/{id}")
	public ResponseEntity<Review> giveReviewForProduct(@RequestBody Review review,@PathVariable("id") Long id) throws UserException, ProductException{
		Review givenReview = userService.giveReview(id, review);
		return new ResponseEntity<Review>(givenReview,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/allReviewsByUser")
	public ResponseEntity<List<Review>> getReviewsByUser() throws UserException{
		List<Review> reviews = userService.getReviewsByUser();
		return new ResponseEntity<List<Review>>(reviews,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/sortByPrice")
	public ResponseEntity<List<Product>> sortByPrice(){
		List<Product> list = userService.sortProductByPrice();
		return new ResponseEntity<List<Product>>(list,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/purchase")
	public ResponseEntity<Order> purchase() throws UserException, WalletException, ProductException{
		Order order = userService.purchaseItems();
		return new ResponseEntity<Order>(order,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/checkBalance")
	public ResponseEntity<Double> checkBalance() throws UserException, WalletException{
		Double bal = userService.checkWalletBalance();
		return new ResponseEntity<Double>(bal,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/addBalance")
	public ResponseEntity<Wallet> addbalance(@RequestParam(required = false) Double amount) throws UserException{
		Wallet wallet = userService.addBalanceToWallet(amount);
		return new ResponseEntity<Wallet>(wallet,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/productDetails/{productId}")
	public ResponseEntity<Product> getProductDetails(@PathVariable("productId") Long productId) throws ProductException{
		Product product= userService.getProductDetails(productId);
		return new ResponseEntity<Product>(product,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/orderDetails/{orderId}")
	public ResponseEntity<Order> getOrderDetails(@PathVariable("orderId") Long orderId) throws UserException, OrderException{
		Order order = userService.getOrderDetails(orderId);
		return new ResponseEntity<Order>(order,HttpStatus.ACCEPTED);
	}
	@GetMapping("/orderHistory")
	public ResponseEntity<List<Order>> getOrderHistory() throws UserException, OrderException{
		List<Order> orders = userService.getOrderHistory();
		return new ResponseEntity<List<Order>>(orders,HttpStatus.ACCEPTED);
	}
	
}
