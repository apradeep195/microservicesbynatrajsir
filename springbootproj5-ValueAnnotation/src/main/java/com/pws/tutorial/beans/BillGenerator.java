package com.pws.tutorial.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("bill")
public class BillGenerator {
	
	@Value("#{info.dosaPrice+info.idlyPrice+infor.pohaPrice}")
	private float total;
	
	@Value("paradise")
	private String hotelName;
	
	@Autowired
	private ItemsInfo items;

	@Override
	public String toString() {
		return "BillGenerator [total=" + total + ", hotelName=" + hotelName + ", items=" + items + "]";
	}
	

}
