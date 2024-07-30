package com.heg.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;


@Entity
@Data
public class MarriageSeeker implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Nonnull
	@Column(length = 50)
	private String name;
	
	@Nonnull
	@Column(length = 100)
	private String addrs;
	
	@Nonnull
	@Lob
	private Blob photo;
	
	@Nonnull
	private Date dob;
	
	@Nonnull
	@Lob
	private Blob biodata;
	
	
	private boolean isIndian;

}
