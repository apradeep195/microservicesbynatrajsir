package com.heg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.heg.model.Employee;
import com.heg.repository.IEmployeeRepo;

@Service("empService")
public class EmloyeeService implements IEmployeeService {

	@Autowired
	private IEmployeeRepo repo;
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return repo.findAll(Sort.by("job").ascending());
	}
	@Override
	public String insertEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return "Employee inserted with ID : " +repo.save(emp).getEmpNo();
	}
	@Override
	public Employee getEmployeeByEno(Long eno) {
		// TODO Auto-generated method stub
		return repo.findById(eno).get();
	}
	
	
	@Override
	public String editEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return "Employee Updated with ID : " +repo.save(emp).getEmpNo();
	}
	@Override
	public String deleteEmployeeByEmpNo(Long eno) {
		// TODO Auto-generated method stub
		repo.deleteById(eno);
		return eno + " employee number Employee deleted "; 
	}

}
