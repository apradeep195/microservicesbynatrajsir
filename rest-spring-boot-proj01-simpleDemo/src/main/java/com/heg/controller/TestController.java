package com.heg.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //(@controller + @responseBody on all the handler methods)
@RequestMapping("/message")
public class TestController {

	@GetMapping("/generate")
	public ResponseEntity<String> generateMessage(){
		//get System date and time 
		LocalDateTime ldt=LocalDateTime.now();
		//get current hours of the day 
		
		int hour= ldt.getHour();
		
		String body=null;
		if(hour<12)
			body ="Good Morning";
		else if(hour<16)
			body="Good AfterNoon";
		else if(hour<20)
			body="Good Evening";
		else 
			body="Good Night";
		
		HttpStatus status=HttpStatus.OK;
		
		//create Response Entity object
		ResponseEntity<String> entity=new ResponseEntity<String>(body,status);
		
		return entity;
	}//method
}//class
