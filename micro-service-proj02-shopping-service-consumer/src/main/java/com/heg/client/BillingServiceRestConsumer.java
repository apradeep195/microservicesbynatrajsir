package com.heg.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceRestConsumer {

	@Autowired
	private DiscoveryClient client;
	
	public String getBillingInfo() {
		//find and get service instance by using service id
		
		List<ServiceInstance> siList=client.getInstances("billing-service");
		
		//use first service instance from th list instance 
		
		ServiceInstance si=siList.get(0);
		//get pprducer MS URl and make it URL
		String url=si.getUri()+"/billing/info";
		//create RestTemplate Object
		
		RestTemplate template=new RestTemplate();
		//invoke producer MS service method or operation by generating HTTP call
		
		String resp=template.getForObject(url, String.class);
		return resp;
		
	}
}
