package com.heg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroServiceProj05EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProj05EurekaServerApplication.class, args);
	}

}
