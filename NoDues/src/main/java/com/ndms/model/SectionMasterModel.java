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
@Table(name="NODUES_SECTION_MASTER")
@Data
public class SectionMasterModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_ID_GEN")
    @SequenceGenerator(name = "SEC_ID_GEN", sequenceName = "NODUES_SECTION_SEQ",initialValue = 1, allocationSize =1)
	private Long ID ;
    
    @Column(name="SEC_DESC")
	private String  sectionDescription;
	
    @Column(name="DEPT_CODE")
	private Integer departmentCode;
}
