package com.example.demo.repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.stream;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecommerce.spring.demo.model.Product;
import com.ecommerce.spring.demo.repository.ProductRepository;
import com.ecommerce.spring.demo.repository.UserRepository;
import com.ecommerce.spring.demo.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepoTest {

	@MockBean
	private UserRepository userRepository;
	
	@MockBean
	private ProductRepository productRepository;
	
	@Autowired
	private UserService userService;
	
	@Test
	void getAllProductsTest() {
		
		Product p1 = new Product();
		p1.setProductId((long) 123);
		p1.setProductName("P1");
		p1.setCategory("C1");
		p1.setQuantity((long)23);
		p1.setPrice(230.00);
		
		Product p2 = new Product();
		p2.setProductId((long) 125);
		p2.setProductName("P2");
		p2.setCategory("C2");
		p2.setQuantity((long)27);
		p2.setPrice(230.00);
//		new Product((long)1235, "p1", "c1", 360.00),new Product((long)1234, "p2", "c2", 360.00)
		when(productRepository.findAll()).thenReturn(
				Stream.of(p1,p2).collect(Collectors.toList()));
		
		assertEquals(2, userService.getAllProducts());
	}
}
