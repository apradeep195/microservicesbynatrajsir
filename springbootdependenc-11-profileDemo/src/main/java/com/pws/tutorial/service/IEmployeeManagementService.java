package com.pws.tutorial.service;

import java.sql.SQLException;
import java.util.List;

import com.pws.tutorial.dto.EmployeeDTO;

public interface IEmployeeManagementService {

	public List<EmployeeDTO> fetchEmployeeByDesignation(String desgs[]) throws SQLException, Exception;
}
