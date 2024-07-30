package com.ndms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ndms.model.EmployeeRoleModel;

@Repository
public interface EmployeeRoleRepository extends JpaRepository<EmployeeRoleModel,Long> {

	EmployeeRoleModel findByEmpCode(String empCode);
	
	
}
