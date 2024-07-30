package com.heg.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.heg.model.EmployeeModel;
import com.heg.service.IEmployeeManagementService;
import com.heg.validator.EmployeeValidator;




@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeManagementService service;
	
	@Autowired
	private EmployeeValidator validator;
	
	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	
	  @GetMapping("/emp_report") 
	  public String showReport(Map<String,Object> map) {
	  //Use Service 
		  List<EmployeeModel> empList=service.getAllEmployee();
		  map.put("empList", empList);
	  
		  //Return LVN 
	  return "report_employee"; 
	  
	  }
	  
	  @GetMapping("/delete_employee")
	 public String removeEmpoyee(@RequestParam("eno") Long empno, 
			 					Map<String, Object> map)  {
		  List<EmployeeModel> empList=service.getAllEmployee();
		  String result=service.deleteEmployee(empno);
		  map.put("empList", empList);
		  map.put("resultMsg", result);		 
		  return  "redirect:emp_report"; 
	 } 
	  

	  
	  @GetMapping("/add_employee")
	  public String showEmployeeForm(@ModelAttribute("emp") EmployeeModel emp) {
		  
		  return "add_employee";
	  }
	  
	//Double Posting problems (USING THIS CONTROLLER OF ADDING REQUEST) SOLUTIONS   
	 /* @PostMapping("/add_employee")
	  public String insertEmployee(	Map<String, Object> map,
	  								@ModelAttribute("emp") EmployeeModel emp) {
		  //Use service
		  String result= service.insertEmployee(emp);
		  List<EmployeeModel> empList=service.getAllEmployee();
		  map.put("resultMsg", result);
		  map.put("empList", empList);
		  return "report_employee";
	  }
	  */
	  
	  //SOLUTION 1 
	  
	  //DOUBLE POSTING PROBLEM USING  Post/Redirect/Get (PRG) 
	  //But there the successfully message not showing 
	  	  
	/*  @PostMapping("/add_employee")
	  public String insertEmployee(	Map<String, Object> map,
	  								@ModelAttribute("emp") EmployeeModel emp) {
		  //Use service
		  String result= service.insertEmployee(emp);
		 
		  map.put("resultMsg", result);		  
		  return "redirect:emp_report";
	  }
	  */
	  
	  
	  //SOLUTION 2 
	  
	  //DOUBLE POSTING PROBLEM USING  
	  //But there the successfully message not showing 
	  	  
	  @PostMapping("/add_employee")
	  public String insertEmployee(RedirectAttributes attrs,
			  						@ModelAttribute("emp") EmployeeModel emp,
			  						BindingResult erros) {
		 if(validator.supports(emp.getClass())) {
			 validator.validate(emp, erros);
			 
			 if(erros.hasErrors())
				 return "add_employee";
		 }
		 
		  
		  //Use service
		  String result= service.insertEmployee(emp);
		 
		//  map.put("resultMsg", result);	
		  attrs.addFlashAttribute("resultMsg",result);
		  return "redirect:emp_report";
	  }
	  
	  
	  @PostMapping("/edit_employee")
	  public String editEmployee(Map<String,Object> map,
			  					@ModelAttribute("emp") EmployeeModel employee ,
			  					BindingResult error) {		  
		 
		  if(validator.supports(employee.getClass())) {
			  validator.validate(employee, error);
			  if(error.hasErrors())
				  return "modify_employee";
		  }
		  //use service 
		  String result=service.updateEmployee(employee);
		  List<EmployeeModel> emplist=service.getAllEmployee();		  
		  map.put("empList", emplist);
		  map.put("resultMsg", result);	
		  
		  //return logical view name
		  return "report_employee";
		  
	  }
	  
	  
	  
	  @GetMapping("/edit_employee")
	  public String showEditEmployeeFormPage(@RequestParam("eno") Long empNo, 
			  								 @ModelAttribute("emp") EmployeeModel emp) {
		  
		  //Use service 
		  EmployeeModel emp1=service.getEmployeeByEmpNo(empNo);
		  BeanUtils.copyProperties(emp1, emp);
		  
		  //logical view name 
		  return "modify_employee";
	  }
	  

//SOLUTION 1 
	  
	  //DOUBLE POSTING PROBLEM USING  Post/Redirect/Get (PRG) 
	  //But there the successfully message not showing 
	  	  
	/*  @PostMapping("/add_employee")
	  public String insertEmployee(Map<String, Object> map,@ModelAttribute("emp") EmployeeModel emp) {
		  //Use service
		  String result= service.insertEmployee(emp);
		 
		  map.put("resultMsg", result);		  
		  return "redirect:emp_report";
	  }
	  */
	  
	  
	 
}
