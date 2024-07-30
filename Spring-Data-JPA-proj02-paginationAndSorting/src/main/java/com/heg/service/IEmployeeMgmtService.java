package com.heg.service;

import com.heg.entity.EmployeeDetails;

public interface IEmployeeMgmtService {

	public Iterable<EmployeeDetails> fetchEmployeeDetails(boolean asc, String... properties );
	public Iterable<EmployeeDetails> fetchDetailsByPageNo(int pageNo,int pageSize,boolean asc, String...props );
}
