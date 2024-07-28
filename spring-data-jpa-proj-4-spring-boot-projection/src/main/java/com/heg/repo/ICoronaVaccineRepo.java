package com.heg.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heg.entity.CoronaVaccine;
import com.heg.type.ResultView;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

	public List<ResultView> findByPriceGreaterThanEqualOrderByPrice(double startPrice);
}
