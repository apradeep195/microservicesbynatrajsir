package com.heg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroServiceProj03BillingServiceProducerLbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProj03BillingServiceProducerLbcApplication.class, args);
	}

}
