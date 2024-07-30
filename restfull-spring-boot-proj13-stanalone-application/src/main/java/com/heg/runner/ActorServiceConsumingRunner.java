package com.heg.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ActorServiceConsumingRunner implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {

		//create rest template class
		
		RestTemplate template=new RestTemplate();
		
		//Define url 
		
		String serviceUrl="http://localhost:4042/actor/wish";
		
		//prepare Http Request with get mode to consume the web service (API)
		
		ResponseEntity<String> response=template.getForEntity(serviceUrl, String.class);
		
		//display the receive details 
		System.out.println("Response Body (output) :: "+response.getBody());
		System.out.println("Response status code value :: "+response.getStatusCodeValue());
		System.out.println("Response status code  :: "+response.getStatusCode().toString());
	}

}
