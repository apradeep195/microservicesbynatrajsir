package com.heg;

import java.io.Closeable;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.heg.controller.MainController;
import com.heg.vo.EmployeeVO;

@SpringBootApplication
public class SpringBoot4RealTimeDiAutoConfigurationApplication {

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
