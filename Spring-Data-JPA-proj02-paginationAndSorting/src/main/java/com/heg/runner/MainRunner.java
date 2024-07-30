package com.heg.runner;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.heg.entity.EmployeeDetails;
import com.heg.service.ICoronaVaccineMgmtService;
import com.heg.service.IEmployeeMgmtService;

@Component
public class MainRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineMgmtService coronaService;
	
	@Autowired
	private IEmployeeMgmtService empService;

	@Override
	public void run(String... args) throws Exception {
		
/*		try {
			Iterable<EmployeeDetails> empList=empService.fetchEmployeeDetails(true,"name");
			empList.forEach(System.out::println);
			
		}catch(DataAccessException dae) {
			
		} */
		
	/*	System.out.println();
		System.out.println("===================================");
		System.out.println();
		
		try {
			Iterable<EmployeeDetails> empList=empService.fetchDetailsByPageNo(2, 10, false, "empno");
			empList.forEach(System.out::println);
			}catch(DataAccessException dae) {
				
			} */
		
		
		try {
			
			Iterable<EmployeeDetails> empList1=empService.fetchDetailsByPageNo(0, 5, false, "name");
			empList1.forEach(emp->System.out.println(emp));
		}catch(DataAccessException dae) {
			
		}
	
	
	}
}
