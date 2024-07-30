package com.heg.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	private int cno;
	private String cname;
	private String cadd;
	private Float billAmt;

}
