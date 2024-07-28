package com.heg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroServiceProj03EurekaServerLbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProj03EurekaServerLbcApplication.class, args);
	}

}
