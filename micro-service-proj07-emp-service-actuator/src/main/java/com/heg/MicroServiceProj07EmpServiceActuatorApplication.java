package com.heg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MicroServiceProj07EmpServiceActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProj07EmpServiceActuatorApplication.class, args);
	}

}
