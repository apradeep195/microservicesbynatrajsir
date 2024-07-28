package com.heg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service("purchaseService")
public class PurchaseOrderImpl implements IpurchaseOrder {

	@Autowired
	private JavaMailSender sender;
	@Override
	public String purchase(String[] items, double[] prices, String[] toEmails) {
		//calcualate the bill amount
		double billAmount=0.0;
		for(double p : prices) 
			billAmount=billAmount+p;
		return null;
	}
	
	public void sendMail(String msg,String subject,String[] toEmails) throws Exception {
		MimeMessage message=sender.createMimeMessage(); //empty email message
		MimeMessageHelper helper=new MimeMessageHelper(message,true);
		helper.setFrom(null);
		
		
	}

}
