package com.heg.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
public class CoronaVaccine implements Serializable {

	@Id //to make property as singuar ID property and to ap with singular pk column
	@Column(name="regNo") //optional if you want to hange column name
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long regNo;
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 50)
	private String company;
	
	@Column(length = 50)
	private String country;
	private Double price;
	private Integer requiredDosesCount;
	public Long getRegNo() {
		return regNo;
	}
	public void setRegNo(Long regNo) {
		this.regNo = regNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getRequiredDosesCount() {
		return requiredDosesCount;
	}
	public void setRequiredDosesCount(Integer requiredDosesCount) {
		this.requiredDosesCount = requiredDosesCount;
	}
	@Override
	public String toString() {
		return "CoronaVaccine [regNo=" + regNo + ", name=" + name + ", company=" + company + ", country=" + country
				+ ", price=" + price + ", requiredDosesCount=" + requiredDosesCount + "]";
	}
	public CoronaVaccine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CoronaVaccine(Long regNo, String name, String company, String country, Double price,
			Integer requiredDosesCount) {
		super();
		this.regNo = regNo;
		this.name = name;
		this.company = company;
		this.country = country;
		this.price = price;
		this.requiredDosesCount = requiredDosesCount;
	}
	
	
	
}
