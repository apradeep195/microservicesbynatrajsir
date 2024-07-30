package com.heg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.heg.beans.BillGenerator;

@SpringBootApplication
public class SpringBoot5Application {

	public static void main(String[] args) {
	 ApplicationContext ctx=	SpringApplication.run(SpringBoot5Application.class, args);
	 
	 BillGenerator generator= ctx.getBean("bill",BillGenerator.class);
	 System.out.println(generator);
	 
	 ((ConfigurableApplicationContext) ctx).close();
	}

}
