package com.ndms.excetion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NDMSExceptionHandler {

	private static final Logger logger=LogManager.getLogger(NDMSExceptionHandler.class);
	
	@ExceptionHandler(AnonymousUserException.class)
	public String validationError(AnonymousUserException ex) {
		logger.info("validationError(AnonymousUserException ex)  0"+ex.getMessage());
		return "error/error";
	}
	
}
