package com.heg.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable {
	private Integer srNo;
	private Integer empno;
	private String name;
	private String email;
	private String city;
	private String country;
	private Integer zip;
	private String dept;
	private String unit;
	private String designation;
	
}
