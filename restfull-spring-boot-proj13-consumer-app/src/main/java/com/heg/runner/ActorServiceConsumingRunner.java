package com.heg.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumingRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		//create rest template class
		
		RestTemplate template=new RestTemplate();
		
		//Define url 
		
		String serviceUrl="http://localhost:4042/provider/actor/wish/{id}/{name}";
		
		//prepare Http Request with get mode to consume the web service (API)
		
		ResponseEntity<String> response=template.getForEntity(serviceUrl, String.class,1001,"Pradeep");
		
		//display the receive details 
		System.out.println("Response Body (output) :: "+response.getBody());
		System.out.println("Response status code value :: "+response.getStatusCodeValue());
		System.out.println("Response status code  :: "+response.getStatusCode().toString()); 
		System.out.println("Response status code  :: "+response.getHeaders().toString());
		
	//	Object obj= template.getForEntity(serviceUrl, String.class);
	//	System.out.println("Response body (OUTPUR)" +obj);
		
		System.exit(0); //stop server automatically
		
	}

}
