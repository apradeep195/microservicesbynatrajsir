package com.heg.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service("wishService")
public class WishMessageServiceImpl implements IWishMessageService {

	@Override
	public String generateWishMessage() {
		// System date time 		
		LocalDateTime ltd=LocalDateTime.now();
		//get Current hours 
	int hour= ltd.getHour();
	
	if(hour<12)
		return "Good Morning";
	else if(hour<16)
		return "Good AfterNoon";
	else if(hour<20)
		return "Good Evening";
	else 
		return "Good Night";		
		
	}

}
