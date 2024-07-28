package com.pws.tutorial;

import java.io.Closeable;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.pws.tutorial.controller.MainController;
import com.pws.tutorial.vo.EmployeeVO;

@SpringBootApplication
public class Springbootdependenc4RealTimeDiAutoConfigApplication {

	public static void main(String[] args) {

		// read inputs from end users
		Scanner sc = new Scanner(System.in);
		System.out.println("Desg count::");
		int count = sc.nextInt();
		String desgs[] = null;
		if (count >= 1) {
			desgs = new String[count];
		} else {
			System.out.println("Invalid desg count");
			return;
		}
		for (int i = 0; i < count; ++i) {
			System.out.println("Enter desg " + (i + 1));
			String desg = sc.next();
			desgs[i] = desg;

		}

		ApplicationContext ctx = SpringApplication.run(Springbootdependenc4RealTimeDiAutoConfigApplication.class, args);

		// get controller class object

		MainController controller = ctx.getBean("controller", MainController.class);
		try {
			List<EmployeeVO> listVO = controller.showEmpByDesgs(desgs);
			listVO.forEach(vo -> {
				System.out.println(vo);
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SOME ENTERNAL PROBLEMS OCCURED" + e.getMessage());
		}
		((ConfigurableApplicationContext) ctx).close();

	}

}
