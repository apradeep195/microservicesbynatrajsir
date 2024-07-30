package com.ndms.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "NODUES_REQ_DETAILS")
@Data
public class NoDuesRequestModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REQ_ID_GEN")
	@SequenceGenerator(name = "REQ_ID_GEN", sequenceName = "NODUES_REQ_SEQ",initialValue = 1, allocationSize =1)
	private Long ID;

	@Column(name = "EMPNO")
	private Long employeeId;

	@Temporal(TemporalType.DATE)
	@Column(name = "RESIGN_DATE")
	private Date resignationDate;


	@Column(name = "INITIATED_BY")
	private Long noduceInsiatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "INITIATE_DATE")
	private Date noduceInsiateDate =new Date();;

	@Column(name = "HOD_APPROVAL_STATUS")
	private Integer deptHODStatus;

	@Column(name = "HOD_CODE")
	private Long deptHODId;

	@Temporal(TemporalType.DATE)
	@Column(name = "HOD_APPROVAL_DATE")
	private Date deptHODDate;

	@Column(name = "HR_HEAD_APPROVA_STATUS")
	private Integer hrHODStatus;

	@Temporal(TemporalType.DATE)
	@Column(name = "HR_HEAD_APPROVA_DATE")
	private Date hrHODDate;

	@Column(name = "HR_HEAD")
	private Long hrHODId;

	@Column(name = "EXGRATIA")
	private Double exgratia;

}
