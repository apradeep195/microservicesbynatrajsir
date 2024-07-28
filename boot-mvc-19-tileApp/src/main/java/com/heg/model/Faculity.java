package com.heg.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tiles_faculty")
public class Faculity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer fid;
	private String fname;
	private String qlfy;
	private String subject;
}
