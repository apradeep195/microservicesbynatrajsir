package com.heg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heg.model.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Long> {

}
