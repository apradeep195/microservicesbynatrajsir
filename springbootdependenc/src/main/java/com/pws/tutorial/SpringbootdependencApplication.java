package com.pws.tutorial;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.pws.tutorial.beans.WishMessageGenerator;

@SpringBootApplication
public class SpringbootdependencApplication {

	@Bean(name="ldt")
	public LocalDateTime createLocalDateTime() {
		System.out.println("springbootdependencyinjection.createLocalDateTime()");
		LocalDateTime ldt=LocalDateTime.now();
		return ldt;
		
	}
	
	public static void main(String[] args) {
		//get IOC Container
	ApplicationContext ctx= SpringApplication.run(SpringbootdependencApplication.class, args);
	WishMessageGenerator generator= ctx.getBean("wmg",WishMessageGenerator.class);
	String result= generator.generateWishMessage("Pradeep Ahirwar");
	System.out.println(result);
	}

}
