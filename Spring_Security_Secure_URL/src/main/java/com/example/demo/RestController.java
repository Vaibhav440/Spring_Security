package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@GetMapping("/save")
	public String getHome()
	{
		return "Home";
	}
	
	@GetMapping("/test")
	public String getTest()
	{
		return "Test is Done";
	}
	
	

}
