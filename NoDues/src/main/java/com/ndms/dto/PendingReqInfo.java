package com.ndms.dto;

import java.util.Date;

public interface PendingReqInfo {
	
	 Long getEMPNO();
	 String getEMPNAME();
	 Long getREQID();
	 Date getRESIGN_DATE();
	 Integer getHR_HEAD_APPROVA_STATUS();
	 Integer getHOD_APPROVAL_STATUS();
	 String getRESIONDESC();
	 Date getLAST_WORKING_DATE();
	 Date getINITIATE_DATE();
	 String getDEPT();
	 String  getDESG();
	 String getPENDINGDEPT();
	 String getREPOSTINGOFFICE();

}
