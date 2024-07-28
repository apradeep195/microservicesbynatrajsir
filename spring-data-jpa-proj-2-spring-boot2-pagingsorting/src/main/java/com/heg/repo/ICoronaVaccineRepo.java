package com.heg.repo;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.heg.entity.CoronaVaccine;

public interface ICoronaVaccineRepo extends PagingAndSortingRepository<CoronaVaccine, Long> {

}
