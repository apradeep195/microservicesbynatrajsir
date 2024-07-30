package com.heg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor")
public class ActorOperationController {

	/*@GetMapping("/wish")
	public ResponseEntity<String> displayWishMessage(){
		
		return new ResponseEntity<String>("Good Morning",HttpStatus.OK);
	}
	
	
	@GetMapping("/wish1")
	public ResponseEntity<String> displayWishMessage1(){
		
		return new ResponseEntity<String>("Good AfterNone",HttpStatus.OK);
	}
	*/
	
	@GetMapping("/wish/{id}/{name}")
	public ResponseEntity<String> displayWishMessage(@PathVariable Integer id,
														@PathVariable String name){
		
		return new ResponseEntity<String>("Good Morning" +name,HttpStatus.OK);
	}
	
	
}
