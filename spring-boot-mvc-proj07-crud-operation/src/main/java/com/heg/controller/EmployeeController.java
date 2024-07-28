package com.heg.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.heg.model.Employee;
import com.heg.service.IEmployeeService;



@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/")
	private String showHomePage() {
		return "home";
	}
	
	
	@GetMapping("/emp_report")
	public String showEmployeeRepost(Map<String,Object> map) {
		List<Employee> empList=service.getAllEmployees();
		
		//keep results as model attributes
		map.put("empList", empList);
		
		//return logical View Name
		return "employee_report";
	}
	
	
	@GetMapping("/insert_employee")
	public String showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {
		return "add_employee";
	}
	
	
	@PostMapping("/insert_employee")
	public String insertEmployee (Map<String,Object> map, @ModelAttribute("emp") Employee emp) {
		//use service 
		String result=	service.insertEmployee(emp);	
		List<Employee> empList=service.getAllEmployees();		
		//add result to model attribute		
		map.put("resultMsg", result);
		map.put("empList", empList);
		return "employee_report";
	}
	
	@GetMapping("/edit_employee")
	public String showEditEmployeeFormPage(	@RequestParam("eno") Long eno,
											@ModelAttribute("emp") Employee emp) {
		//Use Service
	Employee emp1=service.getEmployeeByEno(eno);
	BeanUtils.copyProperties(emp1, emp);
		
		//return LVN
		return "modify_employee";
		
	}
	
	@PostMapping("/edit_employee")
	public String editEmployee(	Map<String,Object> map,
								@ModelAttribute("emp") Employee emp) {
		//use service
		String result= service.editEmployee(emp);
		List<Employee> empList=service.getAllEmployees();
		//keep result to model attribut		
		map.put("resultMsg", result);
		map.put("empList", empList);
		return "employee_report";
	}
	
	@GetMapping("/delete_employee")
	public String deleteEmployee(@RequestParam("eno") Long eno, 
									Map<String,Object> map) {
		//user service 
		String result=service.deleteEmployeeByEmpNo(eno);
		List<Employee> empList=service.getAllEmployees();
		map.put("resultMsg", result);
		map.put("empList", empList);
		return "employee_report";
	}
	
	
}
