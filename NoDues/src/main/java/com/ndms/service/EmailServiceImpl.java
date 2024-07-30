package com.ndms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndms.model.EmailDetails;

@Service
public class EmailServiceImpl implements NoduesMailService {

	
	
	@Override
	public String sendSimpleMail(EmailDetails details) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendMailWithAttachment(EmailDetails details) {
		// TODO Auto-generated method stub
		return null;
	}

}
