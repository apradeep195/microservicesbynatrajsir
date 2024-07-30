package com.heg.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.heg.model.Customer;

@RestController
public class CustomerOperationController {

/* SIMPLE DATA CODE 
 * 	@GetMapping("/report")
	public ResponseEntity<Customer> showData(){
		Customer cust=new Customer(10, "Pradeep", 545.44f);
		HttpStatus status=HttpStatus.OK;
		return new ResponseEntity<Customer>(cust,status);		
	} */
	
	//COMPLEXE DATA CODE
	
	/*@GetMapping("/report1")
	public ResponseEntity<Customer> showData(){
		//body of data 
		
		Customer cust=new Customer(	10,"Pradeep Ahirwar", 45654.44f, 
									new String[] {"Red","Green","Blue","Yellow"}, 
									List.of("10th","12th","B-Tech"),
									Set.of(131211l,54545l,54512l), 
									Map.of("adharNo", "899977778585", 
							                 "panNo", "AXLPA4452D", 
							                 "drivingLicense", "45412544MP"),
									new Company("HEG Limited", "Bhopal","IT",4500));
		
		HttpStatus status=HttpStatus.OK;
		return new ResponseEntity<Customer>(cust,status);
	}*/
	
	
	@PostMapping("/register")
	public String registerCustomer(@RequestBody Customer cust) {
		return cust.toString();
	}
	
}
