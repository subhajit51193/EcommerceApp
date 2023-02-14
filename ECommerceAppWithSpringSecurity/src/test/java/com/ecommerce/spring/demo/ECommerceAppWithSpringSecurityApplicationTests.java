package com.ecommerce.spring.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecommerce.spring.demo.exceptions.ProductException;
import com.ecommerce.spring.demo.exceptions.UserException;
import com.ecommerce.spring.demo.model.Product;
import com.ecommerce.spring.demo.repository.ProductRepository;
import com.ecommerce.spring.demo.repository.UserRepository;
import com.ecommerce.spring.demo.service.ProductService;
import com.ecommerce.spring.demo.service.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
class ECommerceAppWithSpringSecurityApplicationTests {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@MockBean
	private ProductRepository productRepository;
	
	@BeforeEach
	void setup() throws Exception{
		MockitoAnnotations.openMocks(this);
	}
		
	@Test
	public void getProductsTest() {
		
		when(productRepository.findAll()).thenReturn(Stream
				.of(new Product((long)1, "name1", "category1", (long)45, 400.00),new Product((long)2, "name2", "category2", (long)46, 800.00)).collect(Collectors.toList()));
		assertEquals(2, productService.getAllProducts().size());
		
	}
	
	@Test
	public void saveProductsTest() {
		Product product = new Product((long)1, "name1", "category1", (long)45, 400.00);
		when(productRepository.save(product)).thenReturn(null);
//		assertEquals(product, productService.addProduct(product));
		assertThrows(UserException.class, 
				()-> {
					productService.addProduct(product);
				});
	}
	
	@Test
	public void getProductById_productException(){
		
		when(productRepository.findById(anyLong())).thenReturn(null);
//		userService.getProductDetails((long)3);
		assertThrows(ProductException.class,
				()-> {
					userService.getProductDetails((long)3);
				}
				);
	}
	
	
		


}
