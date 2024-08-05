package com.heg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


@SpringBootApplication
@EnableHystrix
public class MicroServiceProj08EmpServiceCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProj08EmpServiceCircuitBreakerApplication.class, args);
	}

}
