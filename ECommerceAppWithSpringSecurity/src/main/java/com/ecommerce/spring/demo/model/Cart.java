package com.ecommerce.spring.demo.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
	
	@ManyToOne
	@JsonIgnore
	private User user;
	
	private Long quantity;
	
//	@ManyToOne
//	@JoinColumn(name = "orderId")
//	@JsonIgnore
//	private Order order;
	
	
	
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	

	
	public Cart(Long cartId, Product product, User user, Long quantity) {
		super();
		this.cartId = cartId;
		this.product = product;
		this.user = user;
		this.quantity = quantity;
	}




	public Cart(Product product, Long quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}




	
	
	
	
}
