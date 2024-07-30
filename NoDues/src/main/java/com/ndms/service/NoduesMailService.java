package com.ndms.service;

import org.springframework.stereotype.Service;

import com.ndms.model.EmailDetails;

@Service
public interface NoduesMailService {

	// Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);
 
    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
	
}
