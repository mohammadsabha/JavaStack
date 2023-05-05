package com.sabha.demo.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {
	
	@RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        // Get the error status code
        int statusCode = (int) request.getAttribute("javax.servlet.error.status_code");
        
        // Set the error message based on the status code
        if (statusCode == 404) {
            model.addAttribute("errorMessage", "Sorry, the page you are looking for could not be found.");
        } else {
            model.addAttribute("errorMessage", "Sorry, something went wrong.");
        }
        
        // Return the error view
        return "error";
    }

    //@Override
    public String getErrorPath() {
        return "/error";
    }
}
