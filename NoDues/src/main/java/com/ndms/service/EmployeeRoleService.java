package com.ndms.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndms.dto.EmployeeRoleDTO;
import com.ndms.model.EmployeeRoleModel;
import com.ndms.repository.EmployeeRoleRepository;
import com.ndms.utils.CommonUtils;

@Service
public class EmployeeRoleService {

	private static final Logger logger=LogManager.getLogger(EmployeeRoleService.class);
	
	@Autowired
	private EmployeeRoleRepository employeeRoleRepo;
	
	public EmployeeRoleDTO getEmployeRoleInfo(String empCode) throws InstantiationException, IllegalAccessException {
		
		EmployeeRoleDTO employeeRoleDTO=null;
		
		EmployeeRoleModel  empModel=employeeRoleRepo.findByEmpCode(empCode);
		
		if(empModel!=null)
		      employeeRoleDTO=CommonUtils.copyProperties(empModel, EmployeeRoleDTO.class);
		
		return employeeRoleDTO;
	}
	
}
