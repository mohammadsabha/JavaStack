package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class DaikichiPathVariablesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaikichiPathVariablesApplication.class, args);
	}
	@RequestMapping("/daikichi/{courseId}/{moduleId}")
	public String showLesson(@PathVariable("courseId") String courseId, @PathVariable("moduleId") String moduleId){
	    if (courseId.equals("travel")) {
	        return "Congratulations! You will soon travel to " + moduleId;
	    }
	    else if (courseId.equals("lotto") && Integer.parseInt(moduleId) % 2 == 0 ) {
	        return "You will take a grand journey in the near future, but be weary of temping offers";
	    }
	    else if (courseId.equals("lotto") && Integer.parseInt(moduleId) % 2 == 1 ) {
	        return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
	    }
	    else {
	        return "sorry";
	    }
	}
}
//return "Course: " + courseId + ", Module: " + moduleId;