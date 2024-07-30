package com.heg.service;

import java.util.List;

import com.heg.model.EmployeeModel;

public interface IEmployeeManagementService {

	public List<EmployeeModel> getAllEmployee();
	
	public String insertEmployee(EmployeeModel emp);
	
	public EmployeeModel getEmployeeByEmpNo(Long emno);
	
	public String updateEmployee(EmployeeModel emp);
	
	public String deleteEmployee(Long empno);
	

}
