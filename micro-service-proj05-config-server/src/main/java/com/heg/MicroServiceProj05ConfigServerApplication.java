package com.heg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicroServiceProj05ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProj05ConfigServerApplication.class, args);
	}

}
