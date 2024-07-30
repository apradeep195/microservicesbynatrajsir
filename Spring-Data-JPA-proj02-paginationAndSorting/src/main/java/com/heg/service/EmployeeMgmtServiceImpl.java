package com.heg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.heg.entity.EmployeeDetails;
import com.heg.repo.IEmployeeDetailRepo;

@Service("empMgmtService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeDetailRepo employeeRepo;

	@Override
	public Iterable<EmployeeDetails> fetchEmployeeDetails(boolean asc, String... properties) {


		Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC,
										properties);
		Iterable<EmployeeDetails> listEntities=employeeRepo.findAll(sort);
		return listEntities;
	}

	@Override
	public Iterable<EmployeeDetails> fetchDetailsByPageNo(int pageNo, int pageSize, boolean asc, String... props) {
		//create pageable object having object 
		
		Pageable pageable=PageRequest.of(	pageNo,
											pageSize,
											asc?Direction.ASC:Direction.DESC,
											props);
		
		Iterable<EmployeeDetails> empList=employeeRepo.findAll(pageable);
		
		return empList;
	}

	

}
