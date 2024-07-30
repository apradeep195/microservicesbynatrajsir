package com.heg.repo;

import org.springframework.data.repository.CrudRepository;

import com.heg.entity.EmployeeEntity;

public interface IEmployeeRepo extends CrudRepository<EmployeeEntity,Long> {

}
