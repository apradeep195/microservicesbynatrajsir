package com.heg.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.heg.model.Employee;

@Controller
public class TestController {

	
	
	@GetMapping("/report")	
	public String showReport(Map<String,Object> map) {
		map.put("name","Pradeep");
		map.put("age",32);
		map.put("address","Bhopal");
		return "show_report";
	}
	
	
	
	@GetMapping("/listRepost")	
	public String showReport1(Map<String,Object> map) {
		
		String nickNames[]=new String[] {"Nick","Nikki","Aaryan","Immy"};
		Set<Long> mobilePhonesSet=new HashSet<>();
		mobilePhonesSet.add(8893365985l);
		mobilePhonesSet.add(8893365986l);
		mobilePhonesSet.add(8893365987l);
		
		List<String> courseList=List.of("Java","Oracle","Servlet","Jsp","Css","JavaScript","Spring");
		Map<String,Long> idsMap=Map.of(		"aadhar", 800028556585l, 
											"license", 66554455l, 
											"voter", 6565485411l);
		
		map.put("nickNames", nickNames);
		map.put("mobilePhonesSet", mobilePhonesSet);
		map.put("courseList", courseList);
		map.put("idsMap", idsMap);		
		
		return "show_report1";
	}
	
	
	@GetMapping("/home")
	public String showHomePage() {

		return "home";

	}
	
	@GetMapping("/emp_register")
	public String showForm() {
		return "register";
	}

	@PostMapping("/emp_register")
	public String registerEmployee(Map<String,Object> map,
								 @ModelAttribute Employee employee) {
		//read and use form data model class object or send to service class
		
		System.out.println(employee);
		return "result";
	}

}
