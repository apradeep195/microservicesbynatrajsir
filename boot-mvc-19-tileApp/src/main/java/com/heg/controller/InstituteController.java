package com.heg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InstituteController {

	@GetMapping("/home")
	public String showHome() {
		return "homePageDef";
	}
}
