package com.heg.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.heg.model.Customer;
import com.heg.service.ICustomerManagementService;

@Controller
public class CustomerController {

	@Autowired
	private ICustomerManagementService service;
	
	@ModelAttribute("countriesInfo")
	public Set<String> populateCountries(){
		
		return service.getAllCountries();
	}
	
	@ModelAttribute("languageInfo")
	public Set<String> getAllLanguages(){
		
		return service.getAllLanguages();
	}
	
	
	@GetMapping("/customerHome")
	public String showCustomerFormPage(@ModelAttribute("cust") Customer customer) {
		return "customer_register";
	}
}
