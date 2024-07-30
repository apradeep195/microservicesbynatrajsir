package com.heg.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.heg.model.Employee;

@Controller
public class TestController {

	
	
	
	@GetMapping("/home")
	public String showHomePage() {

		return "home";

	}
	
	@GetMapping("/emp_register")
	public String showForm(@ModelAttribute("emp") Employee emp) {
		return "register";
	}

	@PostMapping("/emp_register")
	public String registerEmployee(Map<String,Object> map,
								 @ModelAttribute("emp") Employee emp) {
		//read and use form data model class object or send to service class
		
		System.out.println(emp);
		return "result";
	}

}
