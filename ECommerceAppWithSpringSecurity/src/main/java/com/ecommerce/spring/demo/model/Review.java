package com.ecommerce.spring.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.ToString;

@Entity
@ToString
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reviewId;
	
	private Integer rating;
	
	private String subject;
	
	private String description;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "id")
	@JsonIgnore
	private User user;
	
	
	
	public Review() {
		// TODO Auto-generated constructor stub
	}


	public Long getReviewId() {
		return reviewId;
	}


	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}


	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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
	
	
}
