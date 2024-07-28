package com.heg.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heg.model.Company;
import com.heg.model.Customer;

@RestController
public class CustomerController {

	
	/*@GetMapping("/report")
	public ResponseEntity<Customer> showData(){
		Customer cust=new Customer(10001,"Raja","Bhopal",5665.04f);
		HttpStatus status=HttpStatus.OK;
		return new ResponseEntity<Customer>(cust,status);
	}
	*/
	
	@GetMapping("/report")
	public ResponseEntity<Customer> showData1(){
		Customer cust=new Customer(1001, "raja", "Bhopal", 456.5f,
									new String[] {"red","green","blue","black"}, 
									List.of("10th","10+2","B.Tech"), 
									Set.of(4545454l,8545454l,54545121l), 
									Map.of("aadhar",45545454l,"panNo",12547835l),
									new Company("HEG LIMITED", "Mandideep", "Production", 6520));
		HttpStatus status=HttpStatus.OK;
		return new ResponseEntity<Customer>(cust,status);
	}
	
}
