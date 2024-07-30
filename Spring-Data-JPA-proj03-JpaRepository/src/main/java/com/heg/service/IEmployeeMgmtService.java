package com.heg.service;

import java.util.List;

import com.heg.entity.EmployeeDetails;

public interface IEmployeeMgmtService {

	public List<EmployeeDetails> searchEmployeeByGivenData(EmployeeDetails empDetail, 
															boolean asc, 
															String... properties);
	
}
