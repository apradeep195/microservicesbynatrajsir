package com.heg.runner;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.heg.entity.EmployeeDetails;
import com.heg.service.IEmployeeMgmtService;

@Component
public class MainRunner implements CommandLineRunner {

	
	
	@Autowired
	private IEmployeeMgmtService empService;

	@Override
	public void run(String... args) throws Exception {
		

		try {
			
			List<EmployeeDetails> empList=empService.searchEmployeeByGivenData(null, false, args);
			empList.forEach(emp->System.out.println(emp));
			
		}catch(DataAccessException dae) {
			
		}
	
	
	}
}
