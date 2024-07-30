package com.ndms.dto;

import java.util.Date;

//Projection
public interface RegisnationInfo {	
	String  getEMPCODE();
	String  getEMPNAME();
	String  getDESG();
	String  getUNITDESC();
	String  getDEPTDESC();
	Date    getLASTDATE();
	String  getLEAVERESION();
	String  getREPOSTINGOFFICE();
	String  getPENDINGWITH();
	String  getCATCODE();

	
}
