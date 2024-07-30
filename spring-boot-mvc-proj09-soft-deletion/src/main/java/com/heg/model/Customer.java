package com.heg.model;


import lombok.Data;

@Data
public class Customer {

	private Integer cno;
	private String cname;
	private String country="India";
	private String[] languages;
}
