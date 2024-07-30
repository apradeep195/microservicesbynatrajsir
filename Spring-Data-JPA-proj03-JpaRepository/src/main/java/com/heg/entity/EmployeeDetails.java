package com.heg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "emp_detail")
@Data
public class EmployeeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empno;
	
	private String name;
	
	private String email;
	
	private String addr1;
	
	private String addr2;
	
	private String addr3;
	
	private String city;
	
	private String country;
	
	private Long zip;
	
	private Long phone;
	
	private String dept;
	
	private String unit;
	
	private String designation;
	
	private String state;
}
