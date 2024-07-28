//WishMessageGenerator.java
package com.pws.tutorial.beans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {

	@Autowired //Field Level Injection
	private LocalDateTime date;
	
	public WishMessageGenerator() {
		// TODO Auto-generated constructor stub
		System.out.println("0 Param constructor");
	}
	
	public String  generateWishMessage(String user) {
		System.out.println("WishMessageGenerator. generateWishMessage()");
		//get current hours of the day
		
		int hour=date.getHour();
		if(hour<12)
			return "GoodMoring"+user;
		else if(hour<16)
			return "Good AfterNoon::"+user;
		else if(hour<20)
			return "Good Evening"+user;
		else 
			return "Good Night "+user;
		
	}
	
}
