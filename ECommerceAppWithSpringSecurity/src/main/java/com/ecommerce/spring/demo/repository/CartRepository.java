package com.ecommerce.spring.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.spring.demo.model.Cart;
import com.ecommerce.spring.demo.model.Product;
import com.ecommerce.spring.demo.model.User;

public interface CartRepository extends JpaRepository<Cart, Long>{

//	@Query("SELECT new Cart(c.cartId,c.product,c.user,c.quantity) FROM Cart c WHERE c.user.id=?1")
//	@Query("SELECT c.product,c.quantity FROM Cart c WHERE c.user.id=?1")
//	public List<Cart> findByUserId(Long userId);
	
	public List<Cart> findByUser(User user);
	
	public Cart findByProduct(Product product);
	
}
