package com.heg.entity;

import java.io.Serializable;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Table(name="CoronaVaccine")
public class CoronaVaccine implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reqNo;
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 50)
	private String company;
	
	@Column(length = 50)
	private String country;
	
	private Double price;
	
	private Integer requiredDoses;

	@Override
	public String toString() {
		return "CoronaVaccine [reqNo=" + reqNo + ", name=" + name + ", company=" + company + ", country=" + country
				+ ", price=" + price + ", requiredDoses=" + requiredDoses + "]";
	}

	public Long getReqNo() {
		return reqNo;
	}

	public void setReqNo(Long reqNo) {
		this.reqNo = reqNo;
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

	public Integer getRequiredDoses() {
		return requiredDoses;
	}

	public void setRequiredDoses(Integer requiredDoses) {
		this.requiredDoses = requiredDoses;
	}

	public CoronaVaccine(Long reqNo, String name, String company, String country, Double price, Integer requiredDoses) {
		super();
		this.reqNo = reqNo;
		this.name = name;
		this.company = company;
		this.country = country;
		this.price = price;
		this.requiredDoses = requiredDoses;
	}

	public CoronaVaccine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
