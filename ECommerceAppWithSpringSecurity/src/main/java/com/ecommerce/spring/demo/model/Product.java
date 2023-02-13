package com.ecommerce.spring.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	private Integer averageRating;
	
	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<Review> reviews;
	
	
	


	public Product() {
		super();
	}





	public Product(Long productId, String productName, String category,Long quantity,Double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.quantity = quantity;
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





	public List<Review> getReviews() {
		return reviews;
	}





	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}





	public Integer getAverageRating() {
		return averageRating;
	}





	public void setAverageRating(Integer averageRating) {
		this.averageRating = averageRating;
	}
	
	
	
	
}
