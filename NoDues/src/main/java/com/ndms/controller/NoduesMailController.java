package com.ndms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ndms.model.EmailDetails;
import com.ndms.service.NoduesMailService;

@Controller
public class NoduesMailController {

	@Autowired
	private NoduesMailService noduesMailService;

	@PostMapping("/sendMail")
	public String senMail(@RequestBody EmailDetails details) {

		System.out.println("Mail Send Here .........");
		String status = noduesMailService.sendSimpleMail(details);
		return status;

	}

	// Sending email with attachment
	@PostMapping("/sendMailWithAttachment")
	public String sendMailWithAttachment(@RequestBody EmailDetails details) {
		String status = noduesMailService.sendMailWithAttachment(details);

		return status;
	}
}
