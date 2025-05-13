package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringSecuritySecureUrl1Application {

	public static void main(String[] args) {
        String url = "http://localhost:8080/test";

        // Create headers with basic auth
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("vaibhav", "admin123");
        

        // Set the headers to the request
        HttpEntity<String> request = new HttpEntity<String>(headers);

        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Make the request
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        // Print response
        System.out.println("Response: " + response.getBody());
    }
}
