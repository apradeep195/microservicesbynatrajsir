package com.heg.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.heg.entity.Customer;
import com.heg.service.ICustomerManagementService;

@Controller
public class CustomerController {

	@Autowired
	private ICustomerManagementService service;

	@ModelAttribute("countriesInfo")
	public Set<String> populateCountries() {

		return service.getAllCountries();
	}

	@ModelAttribute("languagesInfo")
	public Set<String> populateLanguages() {
		return service.getAllLanguages();
	}
	
	@PostMapping("/customer_register")
	public String registerCustomer(Map<String,Object> map, @ModelAttribute("cust") Customer cust) {
		
		//Return logical view name
		return "show_result";
	}

	@GetMapping("/")
	public String showCustomerFormPage(@ModelAttribute("cust") Customer cust) {
		return "customer_register";
	}
	
	@PostMapping("/states")
	public String showStatesByCountry(@RequestParam("country") String country,@ModelAttribute("cust") Customer cust, Map<String,Object> map) {
		//use service
		
		List<String> stateList= service.getStateByCountry(country);
		
		//Add to model attribute		
		map.put("stateInfo", stateList);
		
		//return LVN
		return "customer_register";
	}
}
