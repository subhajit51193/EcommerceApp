package com.ecommerce.spring.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

@Entity

@ToString
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@NotBlank(message = "Product name must not be blank")
	private String productName;
	
	@NotBlank(message = "Category must not be blank")
	private String category;
	
	@NotNull
	private Long quantity;
	
	@NotNull(message = "Price not be null")
	private Double price;
	
	
	


	public Product() {
		super();
	}





	public Product(Long productId, String productName, String category, Double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.price = price;
	}





	public Long getProductId() {
		return productId;
	}





	public void setProductId(Long productId) {
		this.productId = productId;
	}





	public String getProductName() {
		return productName;
	}





	public void setProductName(String productName) {
		this.productName = productName;
	}





	public String getCategory() {
		return category;
	}





	public void setCategory(String category) {
		this.category = category;
	}





	public Long getQuantity() {
		return quantity;
	}





	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}





	public Double getPrice() {
		return price;
	}





	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	
}
