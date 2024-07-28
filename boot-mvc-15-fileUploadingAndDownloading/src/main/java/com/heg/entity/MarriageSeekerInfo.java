package com.heg.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="boot_marriage_seeker_info")
public class MarriageSeekerInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer profileId;
	@Column(length = 50, nullable = false)
	private String profileName;	
	
	@Column(length = 10)
	private String gender;
	
	@Column(length = 150)
	private String resume;
	
	@Column(length = 150)
	private String photo;
	
}
