package com.heg.dao;

import java.util.List;

import com.heg.bo.EmployeeBO;

public interface IEmployeeDAO {

	public List<EmployeeBO> getEmpsByDesg(String cond) throws Exception;
}
