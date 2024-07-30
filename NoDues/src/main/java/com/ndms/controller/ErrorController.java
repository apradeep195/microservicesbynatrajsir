package com.ndms.controller;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {
	
	private static final Logger logger =LogManager.getLogger(ErrorController.class);
	
	@GetMapping("/{code}")
 public String handleInternalError(@PathParam("code")String code ) {
		logger.info("handleInternalError "+code);
		return code ;	
	}
	
}
