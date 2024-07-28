package com.pws.tutorial.beans;

import org.springframework.stereotype.Component;

@Component("info")
public class ItemsInfo {
	public float idlyPrice;
	public float dosaPrice;
	public float pohaPrice;
	
	@Override
	public String toString() {
		return "ItemsInfo [idlyPrice=" + idlyPrice + ", dosaPrice=" + dosaPrice + ", pohaPrice=" + pohaPrice + "]";
	}
	
	

}
