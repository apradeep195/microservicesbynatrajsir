package com.heg.service;

import java.util.List;

import com.heg.model.Employee;

public interface IEmployeeService {

	public List<Employee> getAllEmployees();
	
	public String insertEmployee(Employee emp);
	
	public Employee getEmployeeByEno(Long eno);
	
	public String editEmployee(Employee emp);
	
	public String deleteEmployeeByEmpNo(Long eno);
}
