package com.ecommerce.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;



@SpringBootApplication
public class ECommerceAppWithSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceAppWithSpringSecurityApplication.class, args);
	}

}
