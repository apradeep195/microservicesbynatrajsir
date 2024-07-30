package com.heg.service;

import java.util.List;

import com.heg.dto.EmployeeDTO;

public interface IEmployeeMgmtService {

	public List<EmployeeDTO> fetchEmpByDesg(String [] desgs) throws Exception;
}
