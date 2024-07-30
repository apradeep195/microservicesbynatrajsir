package com.heg;

import java.beans.PropertyVetoException;
import java.io.Closeable;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.heg.controller.MainController;
import com.heg.vo.EmployeeVO;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@SpringBootApplication
public class SpringBoot4RealTimeDiAutoConfigurationApplication {
	
	@Autowired
	private Environment env;
	
	@Bean(name="cds")
	@Profile("uat")
	public ComboPooledDataSource createC3POD() throws IllegalStateException, PropertyVetoException{
		System.out.println("UAT  ENVIRONMENT ");
		ComboPooledDataSource cds= new ComboPooledDataSource();
		cds.setDriverClass(env.getRequiredProperty("spring.datasource.driver-class-name"));
		cds.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
		cds.setUser(env.getRequiredProperty("spring.datasource.username"));
		cds.setPassword(env.getRequiredProperty("spring.datasource.password"));
		return cds;
		
	}

	public static void main(String[] args) {
	
		//READ INPUT FROM USER
		Scanner sc=new Scanner(System.in);
		System.out.println("DESIGNATION COUNT ::");
		int count=sc.nextInt();
		String desgs[]=null;
		
		if(count>=1) {
			desgs=new String[count];
		}else {
			System.out.println("INVALID DESG");
			System.exit(0);
		}
		//READ 
		for(int i=0;i<count;i++) {
			System.out.println("Enter desg" +(i+1));
			String desg=sc.next();
			desgs[i]=desg;
		}
		
		//GET IOC CONTAINER
		ApplicationContext ctx= SpringApplication.run(SpringBoot4RealTimeDiAutoConfigurationApplication.class, args);
		MainController controller= ctx.getBean("controller",MainController.class);
		
		try {
			List<EmployeeVO> listVO= controller.showEmpsByDesgs(desgs);
			listVO.forEach(vo->{
				System.out.println(vo);
			});
			
		}//try
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("EOME INTERNAL PROBLEM "+e.getMessage());
		}//catch
		
	
		((ConfigurableApplicationContext) ctx).close();
		
	}//main
	

}//class
