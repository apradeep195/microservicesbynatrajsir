package com.heg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroServiceProj06CustomerRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProj06CustomerRestServiceApplication.class, args);
	}

}
