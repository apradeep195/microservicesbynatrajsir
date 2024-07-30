package com.heg.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.heg.model.Cricketer;
import com.heg.service.ICricketerService;

@Controller
public class CricketerController {

	@Autowired
	private ICricketerService service;
	
	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/register")
	public String showCrickerRegistrationPage(@ModelAttribute("cricketer") Cricketer cricketer) {
		
		return "register_cricketer";
	}
	
	@PostMapping("/register")
	public String registerCricketer(@ModelAttribute("cricketer") Cricketer crickter,Map<String,Object> map) {
		//user Service
		
		String message=service.registerCrickter(crickter);
		map.put("message", message);
		
		return "show_result";
		
	}
}
