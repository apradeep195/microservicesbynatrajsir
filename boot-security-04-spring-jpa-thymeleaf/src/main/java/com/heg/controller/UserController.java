package com.heg.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heg.model.UserDetails;
import com.heg.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;
	
	@GetMapping("/add")
	public String showRegistrationPage(@ModelAttribute("userInfo") UserDetails userDetails) {		
		return "user_register";
	}
	

	@PostMapping("/add")
	public String addUserSuccessfully(@ModelAttribute("userInfo") UserDetails userDetails,
										Map<String,Object> map) {		
		
		String result=service.register(userDetails);
		map.put("resultMsg",result);
		return "success";
	}
	
	@RequestMapping("/show_login")
	public String showLoginPage() {
		return "login_form";
	}
}
