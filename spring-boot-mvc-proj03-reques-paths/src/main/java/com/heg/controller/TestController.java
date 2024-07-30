package com.heg.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	@RequestMapping("/home")
	public String showHome() {
		return "home";
	}
	
	//@RequestMapping(value="/report",method = RequestMethod.GET)
	@GetMapping(value={"/report","/report1"})
	//@GetMapping(value = {"/report","/report1","/report2"})
	public String showReport(Map<String,Object> map) {
		
		System.out.println("Test Controller showReport");
		return "display";
	}
	
	
	//@RequestMapping(value="/report",method = RequestMethod.POST)	

//	@GetMapping(value = {"/report","/report1","/report2"})
	@PostMapping(value={"/report","/report1"})
	public String showReport1(Map<String,Object> map) {		
		System.out.println("Test Controller showReport1");
		return "display1";
	}

}
