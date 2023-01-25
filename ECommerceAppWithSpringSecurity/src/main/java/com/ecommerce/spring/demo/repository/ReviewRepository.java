package com.ecommerce.spring.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.spring.demo.model.Review;
import com.ecommerce.spring.demo.model.User;

public interface ReviewRepository extends JpaRepository<Review, Long>{

	public List<Review> findByUser(User user);
}
