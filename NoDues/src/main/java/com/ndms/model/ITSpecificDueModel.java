package com.ndms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import lombok.Data;

@Data
@Entity
@Table(name="NODUES_IT_SPEC_DUE_DETAILS")
public class ITSpecificDueModel {

	@Id
	@GeneratedValue(generator = "IT_SPE_DUE_SEC")
	@SequenceGenerator(name = "IT_SPE_DUE_SEC" ,sequenceName = "NODUES_IT_SPEC_DUE_SEQ",allocationSize = 1,initialValue = 1)
	private Long id;
	
	@Column(name = "ERP_LOGIN_STATUS")
	private Integer erpLogin;
	
	@Column(name = "MAIL_ID_ALOTED")
	private Integer mailId;
	
	@Column(name = "AUTOMAIL_ALOTED")
	private Integer autoMail;
	
	@Column(name = "PC_PRINTER_ALOTED")
	private Integer pcPrinter;
	
	private String remark;
	
	@Column(name = "ERP_LOGIN")
	private String erpLoginName;
	
	
	@Column(name = "ERP_LOGIN_ACTION")
	private Integer erpLoginAction;
	
	@Column(name = "MAIL_TYPE")
	private String mailType;
	
	@Column(name = "MAIL_ID_REMOVED")
	private Integer mailIdRemoved;
	
	
	@Column(name = "AUTOMAIL_REMOVED")
	private Integer automailRemoved;
	
	@Column(name = "PC_PRINTER_RETURN")
	private Integer pcPrinterReturn;
	

	@OneToOne(fetch = FetchType.LAZY)
	@Cascade(CascadeType.DETACH)
	@JoinColumn(name = "REQ_ID",referencedColumnName = "ID")
	private NoDuesRequestModel noDuesReq;
	
}
