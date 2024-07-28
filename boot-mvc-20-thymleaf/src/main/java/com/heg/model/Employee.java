package com.heg.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="emp_mvc")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empNo;
	private String empName;
	private String job;
	private Float salary;
	private Integer deptNo;
}
