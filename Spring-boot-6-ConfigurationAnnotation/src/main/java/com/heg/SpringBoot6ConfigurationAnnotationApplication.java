package com.heg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.heg.beans.CompanyDetails;
import com.heg.beans.CompanyDetails1;

@SpringBootApplication
public class SpringBoot6ConfigurationAnnotationApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SpringBoot6ConfigurationAnnotationApplication.class, args);

		CompanyDetails company = ctx.getBean("company", CompanyDetails.class);
		System.out.println("COMPANY PRINT " + company);

	//	CompanyDetails1 company1 = ctx.getBean("company1", CompanyDetails1.class);
		//System.out.println("COMPANY1 PRINT " + company1);

		((ConfigurableApplicationContext) ctx).close();
	}

}
