package com.heg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/home")
	public String homePage() {
		System.out.println("Controller is working");
		return "home";
	}
	
	
	@RequestMapping("/contact")
	public String contactPage() {
		System.out.println("Contact page Controller is working");
		return "contact";
	}
	
}
