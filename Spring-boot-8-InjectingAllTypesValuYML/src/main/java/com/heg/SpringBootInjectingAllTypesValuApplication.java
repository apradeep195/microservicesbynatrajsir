package com.heg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.heg.model.Employee;

@SpringBootApplication
public class SpringBootInjectingAllTypesValuApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootInjectingAllTypesValuApplication.class, args);
		Employee emp = ctx.getBean("emp", Employee.class);
		System.out.println(emp);
		((ConfigurableApplicationContext) ctx).close();

	}

}
