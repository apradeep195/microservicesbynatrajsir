package com.ndms.utils;

public enum ROLE {
	
	USER("ROLE_USER"),ADMIN("ROLE_ADMIN");
	
	private String value;
	
	private ROLE(String value) {
	this.value=value;
	}

	public String getValue() {
		return this.value;
	}
}
