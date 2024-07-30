package com.heg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heg.model.EmployeeModel;

public interface IEmployeeRepo extends JpaRepository<EmployeeModel, Long> {

}
