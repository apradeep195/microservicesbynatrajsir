package com.ndms.dto;

import java.util.Date;

import lombok.Data;


public interface CertificateDetailsDTO {
Long getEMPNO();
 String	 getEMPNAME();
Date	getRESIGN_DATE();
String	getREASONDESC();
 Integer	getEXGRATIA();
 Date	getLAST_WORKING_DATE();
 Date	getINITIATE_DATE();
 String	getINITIATEDBY();
 String	getHODNAME();
 Date	getHODDATE();
 String	getHRHODNAME();
 Date	getHRHODDATE();
 String	getDEPT();
 String	getDESG();
}
