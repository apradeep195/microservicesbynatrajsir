package com.heg.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("company1")

public class CompanyDetails1 {
	@Value("${org.nit.name}")
	public String name;
	
	@Value("${org.nit.type}")
	public String type;
	
	@Value("${org.nit.location}")
	public String location;
	
	@Override
	public String toString() {
		return "CompanyDetails [name=" + name + ", type=" + type + ", location=" + location + "]";
	}
	
	

}
