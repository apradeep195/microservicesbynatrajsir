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
	public Iterable<CoronaVaccine> fetchDetails(boolean asc, String... properties) {
		// TODO Auto-generated method stub
		 Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC,
				 		properties	);
		Iterable<CoronaVaccine> listEntities=coronaRepo.findAll(sort);
		
		return listEntities;
	}

	@Override
	public Iterable<CoronaVaccine> fetchDetailsByPageNo(int pageNo, int pageSize, boolean asc, String... properties) {
		// create pageable object having inputs
		
		Pageable pageable=PageRequest.of(pageNo,
										 pageSize, 
										 asc?Direction.ASC:Direction.DESC,
										 properties);
		 Page<CoronaVaccine> page  =coronaRepo.findAll(pageable);
		
		return page.getContent();
	}
	

	

}
