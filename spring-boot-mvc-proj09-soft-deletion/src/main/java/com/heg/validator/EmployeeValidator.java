package com.heg.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.heg.model.EmployeeModel;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) { //this method is given to check wheather handler method is 
											//passing correct class object or not 
											//if pass it callas validdate method other wise throws exception
		// TODO Auto-generated method stub
		//return EmployeeModel.class==clazz;
		return clazz.isAssignableFrom(EmployeeModel.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		System.out.println("Empployee Validator.validate");
		//type cating 
		EmployeeModel emp=(EmployeeModel)target;
		//server side validation logic
		//if(emp.getName()==null|| emp.getName().equalsIgnoreCase("")|| emp.getName().length()==0|)
		
		if(emp.getName()==null||emp.getName().isBlank()) 
			errors.rejectValue("name", "emp.name.required");
			else if(emp.getName().length()<5)
				errors.rejectValue("name", "emp.name.minlength");
		
		
		if(emp.getDept()==null) 
			errors.rejectValue("dept", "emp.dept.required");
			
		
		
		if(emp.getUnit()==null||emp.getUnit().isBlank()) 
			errors.rejectValue("unit", "emp.unit.required");
			else if(emp.getUnit().length()<5)
				errors.rejectValue("unit", "emp.unit.minlength");
		
		
		if(emp.getDesignation()==null||emp.getDesignation().isBlank()) 
			errors.rejectValue("designation", "emp.designation.required");
			else if(emp.getDesignation().length()<5)
				errors.rejectValue("designation", "emp.designation.minlength");
		
		
		if(emp.getSal()==null) 
			errors.rejectValue("sal", "emp.sal.required");
			else if(emp.getSal()<10000)
				errors.rejectValue("sal", "emp.sal.minlength");
		
		}
		
		

	}


