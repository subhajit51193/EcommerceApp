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
import com.ecommerce.spring.demo.exceptions.WalletException;
import com.ecommerce.spring.demo.model.Cart;
import com.ecommerce.spring.demo.model.Order;
import com.ecommerce.spring.demo.model.Product;
import com.ecommerce.spring.demo.model.Review;
import com.ecommerce.spring.demo.model.User;
import com.ecommerce.spring.demo.model.Wallet;
import com.ecommerce.spring.demo.repository.CartRepository;
import com.ecommerce.spring.demo.repository.OrderRepository;
import com.ecommerce.spring.demo.repository.ProductRepository;
import com.ecommerce.spring.demo.repository.ReviewRepository;
import com.ecommerce.spring.demo.repository.UserRepository;
import com.ecommerce.spring.demo.repository.WalletRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private WalletRepository walletRepository;

	@Override
	public String addToCart(Long productId, Long quantity) throws UserException, ProductException {
		
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
					throw new ProductException("Product not found or may have been sold out");
				}
				else {
					Product product = opt2.get();
					Cart cart = new Cart();
					cart.setProduct(product);
					cart.setUser(user);
					cart.setQuantity(quantity);
					cartRepository.save(cart);
					return "product has been added to cart";
				}
				
			}
		}
		else {
			throw new UserException("Please Login and try again!!!");
		}
	}

	@Override
	public List<Cart> getItemsOfCart() throws UserException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			Optional<User> opt = userRepository.findByUsername(currentUserName);
			if (opt.isEmpty()) {
				throw new UserException("User not found please try again...");
			}
			else {
				User user = opt.get();
				List<Cart> list = cartRepository.findByUser(user);
				
				return list;
				
			}
		}
		else {
			throw new UserException("Please Login and try again!!!");
		}
	}

	@Override
	public String removefromcart(Long productId) throws UserException, ProductException {
		
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
					throw new ProductException("Product not found or may have already been removed from the cart..");
				}
				else {
					Product product = opt2.get();
					List<Cart> list = cartRepository.findByUser(user);
					for (Cart cart : list) {
						if(cart.getProduct().equals(product)) {
							cartRepository.delete(cart);
							return product.getProductName()+"  has been removed from the cart";
						}
					}
					throw new ProductException("Product not found or may have already been removed from the cart..");
					
				}
				
			}
		}
		else {
			throw new UserException("Please Login and try again!!!");
		}
	}

	@Override
	public List<Product> getAllProducts() {
		
		List<Product> list = productRepository.findAll();
		return list;
	}

	@Override
	public Review giveReview(Long productId,Review review) throws UserException, ProductException {
		
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
					throw new ProductException("Product not found or may have been sold out");
				}
				else {
					Product product = opt2.get();
					review.setProduct(product);
					review.setUser(user);
					if (product.getAverageRating() != null) {
						List<Review> rev = product.getReviews();
						int sum = 0;
						for (Review re : rev) {
							sum = sum + re.getRating();
						}
						product.setAverageRating(sum+review.getRating()/product.getReviews().size());
					}
					else {
						product.setAverageRating(review.getRating());
						
					}
					user.getReviews().add(review);
					
					product.getReviews().add(review);
					
					
					reviewRepository.save(review);
					userRepository.save(user);
					productRepository.save(product);
					return review;
				}
				
			}
		}
		else {
			throw new UserException("Please Login and try again!!!");
		}
	}

	@Override
	public List<Review> getReviewsByUser() throws UserException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			Optional<User> opt = userRepository.findByUsername(currentUserName);
			if (opt.isEmpty()) {
				throw new UserException("User not found please try again...");
			}
			else {
				User user = opt.get();
				List<Review> reviews = reviewRepository.findByUser(user);
				return reviews;
				
			}
		}
		else {
			throw new UserException("Please Login and try again!!!");
		}
	}

	@Override
	public List<Product> sortProductByPrice() {
		
		List<Product> products = productRepository.sortByPrice();
		return products;
	}

	@Override
	public Order purchaseItems() throws UserException, WalletException, ProductException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			Optional<User> opt = userRepository.findByUsername(currentUserName);
			if (opt.isEmpty()) {
				throw new UserException("User not found please try again...");
			}
			else {
				User user = opt.get();
				List<Cart> list = cartRepository.findByUser(user);
				Double totalBill = 0.00;
				for (Cart items: list) {
					totalBill = totalBill + (items.getProduct().getPrice()*items.getQuantity());
				}
				if (totalBill > user.getWallet().getBalance()) {
					throw new WalletException("Now enough balance in wallet");
				}
				else {
					
					for (Cart items : list) {
						if (items.getQuantity() > items.getProduct().getQuantity()) {
							throw new ProductException("Reduce quantity");
						}
					}
					Order newOrder = new Order();
					newOrder.setTotalBill(totalBill);
					newOrder.setUser(user);
					newOrder.setCart(list);
					orderRepository.save(newOrder);
					for (Cart items : list) {
						Product product = items.getProduct();
						product.setQuantity(product.getQuantity()-items.getQuantity());
						productRepository.save(product);
					}
					for (Cart items : list) {
						cartRepository.delete(items);
					}
					return newOrder;
				}
				
				
				
			}
		}
		else {
			throw new UserException("Please Login and try again!!!");
		}
	}

	@Override
	public Double checkWalletBalance() throws UserException, WalletException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			Optional<User> opt = userRepository.findByUsername(currentUserName);
			if (opt.isEmpty()) {
				throw new UserException("User not found please try again...");
			}
			else {
				User user = opt.get();
				Double balance = user.getWallet().getBalance();
				return balance;
				
			}
		}
		else {
			throw new UserException("Please Login and try again!!!");
		}
	}

	@Override
	public Wallet addBalanceToWallet(Double amount) throws UserException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			Optional<User> opt = userRepository.findByUsername(currentUserName);
			if (opt.isEmpty()) {
				throw new UserException("User not found please try again...");
			}
			else {
				User user = opt.get();
				Wallet wallet = user.getWallet();
				wallet.setBalance(wallet.getBalance()+amount);
				walletRepository.save(wallet);
				return wallet;
				
			}
		}
		else {
			throw new UserException("Please Login and try again!!!");
		}
	}

		

	
}
