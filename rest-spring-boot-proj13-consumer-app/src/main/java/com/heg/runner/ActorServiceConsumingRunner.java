package com.heg.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumingRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// Create RestTemplate Class Object
		
		RestTemplate template=new RestTemplate();
		
		//efine service url
		String serviceUrl="http://localhost:8080/actor/wish";
		
		//Generate HttpRequest Call for GET mode to comsume web service(API)
		
		ResponseEntity<String> responseEntity=template.getForEntity(serviceUrl, String.class);
		
		//display the recived details
		
		System.out.println("Response body :: " +responseEntity.getBody());
		System.out.println("Response status code value " +responseEntity.getStatusCodeValue());
		System.out.println("Response status code  " +responseEntity.getStatusCode().toString());
		
		//System.exit()
	}

}
