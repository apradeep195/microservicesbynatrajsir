package com.heg.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
@ConfigurationProperties(prefix = "info.app")
public class EmployeeOperationController {

	@GetMapping("/info")
	public String display() {
		return "Welcome to Call center ";
	}
}
