package com.ndms.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ReginationReqDTO {

	private Long empCode;	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date resignDate; //date resign user 
	
	
	private Double  exgratia;
	
	
	
}
