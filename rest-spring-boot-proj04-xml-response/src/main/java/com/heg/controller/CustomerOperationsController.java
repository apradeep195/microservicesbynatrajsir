package com.heg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heg.model.Customer;

@RestController
public class CustomerOperationsController {

	@GetMapping("/report")
	public Customer showData() {
		Customer cust=new Customer(1001, "Pradeep", "Bhopal", 65852.4f);
		return cust;
	}
}
