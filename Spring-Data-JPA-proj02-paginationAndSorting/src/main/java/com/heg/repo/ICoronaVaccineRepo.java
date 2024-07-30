package com.heg.repo;

import org.springframework.data.repository.CrudRepository;

import com.heg.entity.CoronaVaccine;

public interface ICoronaVaccineRepo extends CrudRepository<CoronaVaccine, Long> {

}
