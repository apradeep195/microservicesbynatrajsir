package com.heg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.heg.model.Customer;

@Controller
public class CustomerController {

	@GetMapping("/")
	public String shoeHome() {
		return "home";
	}
	
	@GetMapping("/customer_register")
	public String showCustomerFormPage(@ModelAttribute("customer") Customer cust) {
		return "register";
	}
}
