package com.ndms.utils;

public enum DateFormat {
	
	DDMMYYYY("dd-MM-yyyy"),TIMESTAMP("dd-MM-yyyy HH:mm:ss"),YYYYMMDD("yyyy-MM-dd"),
	DDMONYYYY("dd MON yyyy"),YYYY("yyyy"),MIN_TIMESTAMP("dd-MM-yyyy HH:mm a")
	;
	
	String dateFormat;
	
	DateFormat(String dateFormt) {
		dateFormat=dateFormt;
	}
	
	public String getFormat() {
		return this.dateFormat;
	}
}
