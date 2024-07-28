package com.pws.tutorial.dao;

import java.util.List;

import com.pws.tutorial.bo.EmployeeBO;

public interface IEmployeeDAO {

	public List<EmployeeBO>  getEmplByDesg(String cond) throws Exception;
}
