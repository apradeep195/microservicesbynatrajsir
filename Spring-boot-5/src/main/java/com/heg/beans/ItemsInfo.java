package com.heg.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("info")
@PropertySource("com/heg/utils/inputs.properties")
public class ItemsInfo {

	@Value("${idly.price}")
	public float idlyPrice;
	
	@Value("${dosa.price}")
	public float dosaPrice;
	
	@Value("${poha.price}")
	public float pohaPrice;
	@Override
	public String toString() {
		return "ItemsInfo [idlyPrice=" + idlyPrice + ", dosaPrice=" + dosaPrice + ", pohaPrice=" + pohaPrice + "]";
	}
	
}
