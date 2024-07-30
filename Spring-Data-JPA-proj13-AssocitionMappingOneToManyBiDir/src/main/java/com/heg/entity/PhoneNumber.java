package com.heg.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="OTM_PHONENUMBER")
public class PhoneNumber implements Serializable {

	@Id
	@SequenceGenerator(name="gen1", sequenceName ="reqno_seq", initialValue = 1000, allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen1")
	private Long regNo;
	
	private Long phoneNumber;
	
	@Column(length = 30)
	private String provider;
	
	@Column(length = 50)
	private String type;
	
	@ManyToOne(targetEntity = Person.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	
	private Person person; //for many to one Association

	public PhoneNumber() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhoneNumber(Long regNo, Long phoneNumber, String provider, String type, Person person) {
		super();
		this.regNo = regNo;
		this.phoneNumber = phoneNumber;
		this.provider = provider;
		this.type = type;
		this.person = person;
	}

	public PhoneNumber(Long phoneNumber, String provider, String type, Person person) {
		super();
		this.phoneNumber = phoneNumber;
		this.provider = provider;
		this.type = type;
		this.person = person;
	}

	public PhoneNumber(Long phoneNumber, String provider, String type) {
		super();
		this.phoneNumber = phoneNumber;
		this.provider = provider;
		this.type = type;
	}

	public Long getRegNo() {
		return regNo;
	}

	public void setRegNo(Long regNo) {
		this.regNo = regNo;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "PhoneNumber [regNo=" + regNo + ", phoneNumber=" + phoneNumber + ", provider=" + provider + ", type="
				+ type + "]";
	}
	
	
	
	
}
