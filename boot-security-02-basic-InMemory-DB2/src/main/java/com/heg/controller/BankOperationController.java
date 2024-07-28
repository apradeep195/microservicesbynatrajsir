package com.heg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankOperationController {

	@GetMapping("/home")
	public String showHome() {
		return "home";
	}
	@GetMapping("/balance")
	public String checkBalance() {
		return "balance";
	}
	
	
	@GetMapping("/offers")
	public String showOffers() {
		return "offers";
	}
	
	@GetMapping("/loanApprove")
	public String approveLoan() {
		return "loan";
	}
	
	@GetMapping("/access_denied")
	public String accessDenied() {
		return "access_denied";
	}
	
	@GetMapping("/timeout")
	public String timeoutMethod() {
		return "timeoutJSP";
	}
}
