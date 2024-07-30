package com.heg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heg.entity.EmployeeEntity;
import com.heg.repo.IEmployeeRepo;

@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepo employeeRepo;
	
	@Override
	public Iterable<EmployeeEntity> fetchAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

}
