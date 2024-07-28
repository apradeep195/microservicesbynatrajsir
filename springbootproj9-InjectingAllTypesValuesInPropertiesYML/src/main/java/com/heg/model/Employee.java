package com.heg.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;


@Component("emp")
@ConfigurationProperties(prefix = "emp.info")
@PropertySource("file:src/main/resources/com/heg/common/info.yml")
public class Employee {
	private String name;
	private long id;
	private String[] nickNames;
	private List<String> teamMembers;
	private Set<Long> phoneNumbers;
	private Map<String,String> idDetails;
	private Company comDetail;
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
	public Set<Long> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(Set<Long> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public Map<String, String> getIdDetails() {
		return idDetails;
	}
	public void setIdDetails(Map<String, String> idDetails) {
		this.idDetails = idDetails;
	}
	public Company getComDetail() {
		return comDetail;
	}
	public void setComDetail(Company comDetail) {
		this.comDetail = comDetail;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", nickNames=" + Arrays.toString(nickNames) + ", teamMembers="
				+ teamMembers + ", phoneNumbers=" + phoneNumbers + ", idDetails=" + idDetails + ", comDetail="
				+ comDetail + "]";
	}
	
	
	
	

}
