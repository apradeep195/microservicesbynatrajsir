package com.heg.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	private int cno;
	private String cname;	
	private Float billAmt;
	
	//Complete DATA Start Here 
	private String[] favColors;
	private List<String> studies;
	private Set<Long> phoneNumbers;
	private Map<String,Object> idDetails;
	
	//Has A Property
	private Company compay;
	

}
