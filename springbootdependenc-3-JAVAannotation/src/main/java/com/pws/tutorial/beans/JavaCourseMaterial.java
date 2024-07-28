package com.pws.tutorial.beans;

import javax.inject.Named;



@Named("java")

public class JavaCourseMaterial implements ICourseMaterial {

	
	
	public JavaCourseMaterial() {
		System.out.println("JacaCourse material 0 param constructor");
	}

	@Override
	public String courseContent() {
		// TODO Auto-generated method stub
		System.out.println("JavaCourseMaterial.courseContent");
		return "1. Oops , 2. Exception handling 3. collection framework";
	}

	@Override
	public double price() {
		// TODO Auto-generated method stub
		System.out.println("JavaCourseMaterial.price");
		return 5000;
	}

	

}
