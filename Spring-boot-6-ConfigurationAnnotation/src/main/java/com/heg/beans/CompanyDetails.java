package com.heg.beans;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("company")
@ConfigurationProperties(prefix = "org.nit") 
public class CompanyDetails {
	
	private String name;
	private String type;
	
	@Value("${my.app.addrs}")
	private String address;
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getLocation() {
		return address;
	}



	public void setLocation(String location) {
		this.address = location;
	}



	@Override
	public String toString() {
		return "CompanyDetails [name=" + name + ", type=" + type + ", location=" + address + "]";
	}

	
	
	

}
