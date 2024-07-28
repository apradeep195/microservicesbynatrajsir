package com.heg.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceRestConsumer {

	@Autowired
	private LoadBalancerClient client;
	
	public String getBillingInfo() {
		
		//get less factor service instamce
		ServiceInstance si=client.choose("billing-service");
		
		String url= si.getUri()+"/billing/info";
		
		//create Rest templte Object
		RestTemplate template=new RestTemplate();
		
		//invoke producer MS service method or operation by generating HTTP call
		String resp=	template.getForObject(url,String.class);
		
		return resp;
		
	}
}
