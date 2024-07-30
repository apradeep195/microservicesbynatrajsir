package com.heg.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.heg.entity.EmployeeDetails;

public interface IEmployeeDetailRepo extends JpaRepository<EmployeeDetails, Long> {

}
