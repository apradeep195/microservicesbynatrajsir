package com.heg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.heg.entity.CoronaVaccine;
import com.heg.views.View;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

	public <T extends View>  List<T> findByCompanyOrderByCompanyDesc(String company,Class<T> clazz);
}
