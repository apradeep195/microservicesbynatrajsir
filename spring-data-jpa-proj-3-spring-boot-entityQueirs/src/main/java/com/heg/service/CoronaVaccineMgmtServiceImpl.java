package com.heg.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.heg.entity.CoronaVaccine;
import com.heg.repo.ICoronaVaccineRepo;
@Service("vaccineMgmtService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo coronaRepo;

	@Override
	public List<CoronaVaccine> fetchVaccineByCompany(String company) {
		// TODO Auto-generated method stub
		return coronaRepo.findByCompany(company);
	}



	
	

}
