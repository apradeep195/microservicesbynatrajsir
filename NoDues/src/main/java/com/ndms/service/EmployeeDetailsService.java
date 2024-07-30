package com.ndms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndms.dto.PendingReqInfo;
import com.ndms.repository.EmployeesDetailsRepository;

@Service
public class EmployeeDetailsService {

	@Autowired
	private EmployeesDetailsRepository employeeRepo;
	
	public PendingReqInfo getAllResignation(Long reqid){	
		 return employeeRepo.getEmployeeDetails(reqid);
	}
}
