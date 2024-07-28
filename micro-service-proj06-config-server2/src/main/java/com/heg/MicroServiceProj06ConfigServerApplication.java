package com.heg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicroServiceProj06ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProj06ConfigServerApplication.class, args);
	}

}
