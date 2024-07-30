package com.heg.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//@ControllerAdvice
@RestControllerAdvice
public class TouristErrorHandler {

	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleTouristNotFound(TouristNotFoundException tnf){
		System.out.println("===handleTouristNotFound===");
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(),tnf.getMessage()," 404 - Tourist Not Found ");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
	}
	
	
//For all Exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllProbles(Exception e){
		System.out.println("===handleAllProbles===");
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(),e.getMessage(),"Problem in Execution ");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
