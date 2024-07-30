package com.heg.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.heg.repository.IEmployeeRepo;

public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeRepo repo;
	
}
