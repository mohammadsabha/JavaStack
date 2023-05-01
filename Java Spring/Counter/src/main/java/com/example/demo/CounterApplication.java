package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.ArrayList;
import jakarta.servlet.http.HttpSession;


@SpringBootApplication
@Controller
public class CounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounterApplication.class, args);
	}
	@RequestMapping("/")
    public String index(HttpSession session , Model model) {
		Integer count = (Integer) session.getAttribute("count");
		//session.setAttribute("count", 0);
		if (session.getAttribute("count") == null) {
            count = 0;
        }
        count++;
        session.setAttribute("count", count);
        model.addAttribute("count", count);
        return "index.jsp";
    }
	@RequestMapping("/counter")
    public String counter(HttpSession session , Model model) {
		Integer count = (Integer) session.getAttribute("count");
        model.addAttribute("count", count);
        //return "counter";
    	return "counter.jsp";
    }
}
