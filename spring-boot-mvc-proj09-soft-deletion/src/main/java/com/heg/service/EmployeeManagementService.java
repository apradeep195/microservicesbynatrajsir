package com.heg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.heg.model.EmployeeModel;
import com.heg.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeManagementService implements IEmployeeManagementService {

	@Autowired
	private IEmployeeRepo repo;

	@Override
	public List<EmployeeModel> getAllEmployee() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public String deleteEmployee(Long empno) {
		// TODO Auto-generated method stub

		repo.deleteById(empno);
		return "Empno == " + empno + " has been removed from database ";
	}

	@Override
	public String insertEmployee(EmployeeModel emp) {
		// TODO Auto-generated method stub
		return repo.save(emp).getEno() + " No has been added successfully";
	}

	@Override
	public EmployeeModel getEmployeeByEmpNo(Long emno) {
		// TODO Auto-generated method stub
		return repo.findById(emno).get();
	}

	@Override
	public String updateEmployee(EmployeeModel emp) {
		// TODO Auto-generated method stub
		return repo.save(emp).getEno() + "  Emplyee has been updated Succesully";
	}
}
