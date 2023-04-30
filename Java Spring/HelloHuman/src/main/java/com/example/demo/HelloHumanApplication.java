package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class HelloHumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
	}
	@RequestMapping("/")
	public String handleRequest(@RequestParam(value="q", required=false) String searchQuery) {
	    if (searchQuery != null) {
	        return "You searched for: " + searchQuery;
	    } else {
	        return "Hello Human";
	    }
	}

}
