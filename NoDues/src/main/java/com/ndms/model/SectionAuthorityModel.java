package com.ndms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name="NODUES_SECTION_AUTHORITIES")
@Data
public class SectionAuthorityModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTH_ID_GEN")
	@SequenceGenerator(name = "AUTH_ID_GEN", sequenceName = "NODUES_SEC_AUTHO_SEQ",initialValue = 1, allocationSize =1)
	private Long ID;

	@Column(name = "SEC_ID")
	private Long sectionID;

	@Column(name = "EMP_CODE")
	private Long employeeCode;

	@Temporal(TemporalType.DATE)
	@Column(name = "ACCESS_FROM")
	private Date accessFrom;

	@Temporal(TemporalType.DATE)
	@Column(name = "ACCESS_TO")
	private Date accessTo;

	@Column(name = "STATUS")
	private int status;
}
