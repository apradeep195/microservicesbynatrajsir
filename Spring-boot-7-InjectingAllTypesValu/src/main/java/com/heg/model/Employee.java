package com.heg.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;



@Component("emp")
@ConfigurationProperties(prefix = "emp.info")
public class Employee {

	private String name;
	private long id;
	private String[] nickNames;
	private List<String> teamMembers;
	private Set<Long> phoneNo;
	private Map<String,String> idDetails;
	private Company companyDetails;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String[] getNickNames() {
		return nickNames;
	}
	public void setNickNames(String[] nickNames) {
		this.nickNames = nickNames;
	}
	public List<String> getTeamMembers() {
		return teamMembers;
	}
	public void setTeamMembers(List<String> teamMembers) {
		this.teamMembers = teamMembers;
	}
	public Set<Long> getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Set<Long> phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Map<String, String> getIdDetails() {
		return idDetails;
	}
	public void setIdDetails(Map<String, String> idDetails) {
		this.idDetails = idDetails;
	}
	public Company getCompanyDetails() {
		return companyDetails;
	}
	public void setCompanyDetails(Company companyDetails) {
		this.companyDetails = companyDetails;
	}
	@Override
	public String toString() {
		return "Employee TEST [name=" + name + ", id=" + id + ", nickNames=" + Arrays.toString(nickNames) + ", teamMembers="
				+ teamMembers + ", phoneNo=" + phoneNo + ", idDetails=" + idDetails + ", companyDetails="
				+ companyDetails + "]";
	}
	
	
	
 	
}
