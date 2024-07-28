package com.pws.tutorial.beans;


import javax.inject.Inject;
import javax.inject.Named;



@Named("stud")
public class Student {

	@Inject	
	//@Qualifier("${course.choose}")
	@Named("courseId")
	private ICourseMaterial material;
	
	public void preparation(String examName) {
		System.out.println("Preparation Started for " +examName);
		String courseContent=material.courseContent();
		double price=material.price();
		System.out.println("Preparation is going on using "+courseContent + " with price " +price);
		System.out.println("Preparation is completed for " +examName);
	}
}
