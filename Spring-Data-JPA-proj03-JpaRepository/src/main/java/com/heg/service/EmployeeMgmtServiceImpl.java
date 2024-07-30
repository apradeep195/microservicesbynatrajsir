package com.heg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
	public List<EmployeeDetails> searchEmployeeByGivenData(EmployeeDetails empDetail, boolean asc,
			String... properties) {
		// TODO Auto-generated method stub
		Example example=Example.of(empDetail);
		Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC,properties);
		List<EmployeeDetails> empEntities=employeeRepo.findAll(example,sort);
		return empEntities;
	}


	

	

}
