package com.ndms.dto;

import java.util.Date;

public interface CertificateDuesDTO {

String	getSECTIONNAME();
String	getAPPROVERNAME();
String	getDUE_DETAIL();
Integer getDUE_AMOUNT();
Date getENTERED_DATE();
Date getSUBMITTED_DATE();
}
