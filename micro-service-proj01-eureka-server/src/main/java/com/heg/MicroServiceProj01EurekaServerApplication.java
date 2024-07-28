package com.heg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroServiceProj01EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProj01EurekaServerApplication.class, args);
	}

}
