package com.heg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class MicroServiceProj09EmpServiceCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProj09EmpServiceCircuitBreakerApplication.class, args);
	}

}
