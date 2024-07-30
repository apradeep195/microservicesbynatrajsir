package com.ndms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "NODUES_USER_ROLES")
@Data
public class EmployeeRoleModel {

	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ROLES_SEQ")
	@SequenceGenerator(name ="ROLES_SEQ",sequenceName = "NDMS_ROLE_SEQ",initialValue = 1,allocationSize = 1)
	@Id
	private Long id;

	@Column(name = "EMP_CODE")
	private String empCode;
	
	@Column(name = "DEPT")
	private String department;
	
	private String role;
	
}
