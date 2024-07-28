package com.pws.tutorial.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("dotNet")
//@Primary
public class DotNetCourseMaterial implements ICourseMaterial {

	
	
	public DotNetCourseMaterial() {
		System.out.println("DotNet Course Material  0 param constructor");
	}

	@Override
	public String courseContent() {
		// TODO Auto-generated method stub
		System.out.println("DotNet Course Material.courseContent");
		return "1. Oops , 2. Exception handling 3. collection framework";
	}

	@Override
	public double price() {
		// TODO Auto-generated method stub
		System.out.println("DotNetCourseMaterial.price");
		return 5000;
	}

	

}
