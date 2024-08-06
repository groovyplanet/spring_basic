package com.simple.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String hello() {
		
		System.out.println("111111111");
		return "집에 가고 싶다";
	}
	
	
	
	
}
