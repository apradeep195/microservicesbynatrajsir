package com.pws.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.pws.tutorial.beans.BillGenerator;

@SpringBootApplication
public class Springbootproj5ValueAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(Springbootproj5ValueAnnotationApplication.class, args);
		//get spring bean class object
		
	 BillGenerator generator=	ctx.getBean("bill",BillGenerator.class);
	 System.out.println("data : : " +generator);
	 
	 ((ConfigurableApplicationContext) ctx).close();
	}

}
