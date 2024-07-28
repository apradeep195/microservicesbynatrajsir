package com.heg.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeOperationController {

	@Value("${dbUser}")
	private String user;

	@Value("${dpPwd}")
	private String pass;
	
	
	@GetMapping("/show")
	public String showData() {
		return " (====EMPLOYEE=====)Data Collected Through Config server :: " +user + " password :: "+pass;
	}

}
