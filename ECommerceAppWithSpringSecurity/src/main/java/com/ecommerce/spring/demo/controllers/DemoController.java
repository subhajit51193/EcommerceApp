package com.ecommerce.spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.spring.demo.service.UserService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class DemoController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<String> welcomeMessage(){
		String res = userService.welcomeMessage();
		return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
	}
}
