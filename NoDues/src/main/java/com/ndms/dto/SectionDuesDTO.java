package com.ndms.dto;

import java.util.Date;

public interface SectionDuesDTO {
	
	
	 Long getID();
	 Long getSEC_ID();
	 Long getREQ_ID();
	 Long getENTERED_BY();
	Date getENTERED_DATE();
	String getDUE_DETAIL();
	Double getDUE_AMOUNT();
	Integer getSTATUS();
	Date getSUBMITTED_DATE();
	String getENTRD_BY_NAME();
	
	
	
}
