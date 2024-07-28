package com.pws.tutorial.beans;

import javax.inject.Named;



@Named("UI")
public class UICourseMaterial implements ICourseMaterial {

	
	
	public UICourseMaterial() {
		System.out.println("UICourseMaterial  0 param constructor");
	}

	@Override
	public String courseContent() {
		// TODO Auto-generated method stub
		System.out.println("UICourseMaterial.courseContent");
		return "1. Oops , 2. Exception handling 3. collection framework";
	}

	@Override
	public double price() {
		// TODO Auto-generated method stub
		System.out.println("UICourseMaterial.price");
		return 5000;
	}

	

}
