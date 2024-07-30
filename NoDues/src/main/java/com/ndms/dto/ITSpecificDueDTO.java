package com.ndms.dto;

import lombok.Data;

@Data
public class ITSpecificDueDTO {

	private Long id;
	
	private Integer erpLogin;
	
	private String erpUser;
	
	private String erpLoginName;
	
	private Integer mailId;
	
	private String  mailType;
	
	private Integer autoMail;
	
	private Integer pcPrinter;
	
	private Integer erpLoginAction;
	
	private Integer mailIdRemoved;
	
	private Integer automailRemoved;
	
	private Integer pcPrinterReturn;
	
	private String remark;

	private Long reqId;
	
	private int isSubmitted;
}
