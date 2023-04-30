package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.springframework.ui.Model;

@SpringBootApplication
@Controller
public class DisplayDateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplayDateApplication.class, args);
	}
	@RequestMapping("/")
    public String index() {
    	return "index.jsp";
    }
	@RequestMapping("/date")
    public String date(Model model) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		String formattedDate = dateFormat.format(currentDate);
		model.addAttribute("formattedDate", formattedDate);
    	return "date.jsp";
    }
	@RequestMapping("/time")
    public String time(Model model) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date currentTime = new Date();
        String formattedTime = timeFormat.format(currentTime);
        model.addAttribute("formattedTime", formattedTime);
        System.out.println("The current time is: " + formattedTime);
    	return "time.jsp";
    }
}
