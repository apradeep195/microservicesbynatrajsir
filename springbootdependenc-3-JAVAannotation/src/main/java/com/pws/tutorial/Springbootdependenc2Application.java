package com.pws.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.pws.tutorial.beans.Student;

@SpringBootApplication
@ImportResource("com/pws/tutorial/cnfg/applicationContext.xml")
public class Springbootdependenc2Application {

	public static void main(String[] args) {
		//GET IOC COntainer
	ApplicationContext ctx=	SpringApplication.run(Springbootdependenc2Application.class, args);
	
	Student st= ctx.getBean("stud", Student.class);
	//invoke business method 
	st.preparation("CTS - interview");
	((ConfigurableApplicationContext) ctx).close();
	}

}
