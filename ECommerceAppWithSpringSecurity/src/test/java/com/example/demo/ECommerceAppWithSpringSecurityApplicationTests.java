package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecommerce.spring.demo.model.Product;
import com.ecommerce.spring.demo.repository.ProductRepository;
import com.ecommerce.spring.demo.repository.UserRepository;
import com.ecommerce.spring.demo.service.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
class ECommerceAppWithSpringSecurityApplicationTests {

	@Autowired
	UserService userService;
	
	@MockBean
	ProductRepository productRepository;
	
		
	@Test
	public void contextLoads() {
		
		
	}
	
	@Test
	public void getAllProductsTest() {
		
		when(productRepository.findAll()).thenReturn(Stream
				.of(new Product((long)123, "p1", "c2", 20.00), new Product((long)124, "p2", "c2", 10.00)).collect(Collectors.toList()));
		assertEquals(2, userService.getAllProducts());
	}
		


}
