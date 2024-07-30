package com.ndms.dto;

import java.util.Date;

public interface HODPendingReqInfo {
	
	 Long getREQID();
	 Long getEMPNO();
	 String getEMPNAME();	 
	 Date getRESIGN_DATE();
	 Date getLAST_WORKING_DATE();
	 String getRESIONDESC();
	 Date getINITIATE_DATE();
	 String getDEPT();
	 String  getDESG();	 
	 Integer getHR_HEAD_APPROVA_STATUS();
	 Integer getHOD_APPROVAL_STATUS();
	 Integer getREASON();

	 
}
