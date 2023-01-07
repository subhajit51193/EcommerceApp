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
@Data
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
	
	
	
	
}
