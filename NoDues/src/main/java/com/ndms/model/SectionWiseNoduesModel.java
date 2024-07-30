package com.ndms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "NODUES_SECTIONWISE_ND_DETAILS ")
@Data
public class SectionWiseNoduesModel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_WISE_ID_GEN")
	@SequenceGenerator(name = "SEC_WISE_ID_GEN", sequenceName = "NODUES_SECTIONWISE_ND_SEQ",initialValue = 1, allocationSize =1 )
	private Long ID;

	@Column(name="SEC_ID")
	private Long sectionID;
	
	@Column(name="REQ_ID")
	private Long requestID;
	
	@Column(name="ENTERED_BY")
	private Long enteredEmpCode;
	
	@Column(name="ENTERED_DATE")
	private Date enteredDate;
	
	@Column(name="DUE_DETAIL")
	private String dueDescription;
	
	@Column(name="DUE_AMOUNT")
	private double dueAmount;
	
	@Column(name="STATUS")
	private int status;
	
	@Column(name="SUBMITTED_DATE")
	private Date submittedDate;

}
