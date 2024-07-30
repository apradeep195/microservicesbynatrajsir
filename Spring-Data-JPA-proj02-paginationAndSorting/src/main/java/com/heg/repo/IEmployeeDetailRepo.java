package com.heg.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.heg.entity.EmployeeDetails;

public interface IEmployeeDetailRepo extends PagingAndSortingRepository<EmployeeDetails, Long> {

}
