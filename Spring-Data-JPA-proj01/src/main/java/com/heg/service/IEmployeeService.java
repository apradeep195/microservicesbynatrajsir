package com.heg.service;

import com.heg.entity.EmployeeEntity;

public interface IEmployeeService {

	public Iterable<EmployeeEntity> fetchAllEmployees();
	
}
