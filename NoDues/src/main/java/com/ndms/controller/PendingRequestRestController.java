package com.ndms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ndms.model.APIResponse;

@RestController
@RequestMapping("/api")
public class PendingRequestRestController {

	@PostMapping("/request/pending")
	public APIResponse<?> getPendingRequest(@RequestParam("role") String role,@RequestParam("userid") Long empCode){
	
		APIResponse<?> apiResponse=null;
		try {
			
			apiResponse=APIResponse.builder()
				    .status(true)
				    .message("Successfully")
				    .data(apiResponse)
				    .build();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			apiResponse=APIResponse.builder()
					    .status(false)
					    .message(ex.getMessage())
					    .data(null)
					    .build();
					
		}
		return apiResponse;
	}
	
}
