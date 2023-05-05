package com.sabha.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sabha.demo.models.Travels;
import com.sabha.demo.services.TravelsService;

import jakarta.validation.Valid;

@Controller
public class SaveTravels {
	private final TravelsService travelsService;
	
	public SaveTravels(TravelsService travelsService) {
		this.travelsService =travelsService;
	}
	
	@GetMapping("/")
    public String newTravels(@ModelAttribute("travel") Travels travel, Model model) {
    	List<Travels> alltravels = travelsService.allTravels();
        model.addAttribute("alltravels", alltravels);
             return "expense.jsp";
        }
	@PostMapping("/travel")
    public String add(@Valid @ModelAttribute("travel") Travels travel, BindingResult result, Model model) {
    	if (result.hasErrors()) {
        	List<Travels> alltravels = travelsService.allTravels();
            model.addAttribute("alltravels", alltravels);          
        	return "expense.jsp";
        } else {
        	travelsService.addTravels(travel);
            return "redirect:/";
        }
    }
	@RequestMapping("/expense/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
		Travels travel = travelsService.findTravels(id);
        model.addAttribute("travel", travel);
        return "edit.jsp";
    }
    
    @RequestMapping(value="/expense/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("travel") Travels travel, BindingResult result, Model model , @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            model.addAttribute("travel", travel);
            return "edit.jsp";
        } else {
        	travel.setId(id); // set the ID of the travel object to the path variable ID
            travelsService.updateTravels(travel);
            return "redirect:/";
        }
    }
    //DeleteMapping("/expense/{id}")
    //public String destroy(@PathVariable("id") Long id) {
    //	travelsService.deleteTravels(id);
    //   return "redirect:/";
    //
    @RequestMapping(value="/expense/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	travelsService.deleteTravels(id);
        return "redirect:/";
    }
    @GetMapping("/expense/{id}")
    public String showExpense(@ModelAttribute("travel") Travels travel, Model model , @PathVariable("id") Long id) {
    	//travelsService.findTravels(id);
    	Travels expense = travelsService.findTravels(id);
        model.addAttribute("expense", expense);
             return "show.jsp";
        }
}
