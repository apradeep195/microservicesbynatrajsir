package com.heg.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.heg.entity.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

	public List<CoronaVaccine> findByCompany(String company);
}
