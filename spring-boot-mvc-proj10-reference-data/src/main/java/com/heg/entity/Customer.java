package com.heg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class Customer {	
	private Integer cno;
	private String cname;
	private String country;
	private String[] languages=new String[] {"Hindi","English"};
	private String state;
}
