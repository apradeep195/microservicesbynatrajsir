package com.heg.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heg.entity.CoronaVaccine;
import com.heg.repo.ICoronaVaccineRepo;
import com.heg.views.View;

@Service("vaccineMgmtService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo coronaRepo;

	@Override
	public List<CoronaVaccine> fetchVaccineByComapny(String company) {
		// TODO Auto-generated method stub
		return coronaRepo.serachVaccineByComapny(company);
	}

	@Override
	@Transactional
	public int updatePriceByCountry(double price, String country) {
		// TODO Auto-generated method stub
		return coronaRepo.updatePriceByCountry(price, country);
	}

	@Override
	@Transactional
	public int deleteVaccineByPrice(double startPrice, double endPrice) {
		// TODO Auto-generated method stub
		return coronaRepo.deleteVaccineByPriceRange(startPrice, endPrice);
	}

	@Override
	public int registerVaccine(Double price, int required_doses, Long req_no, String company, String country,
			String name) {
		// TODO Auto-generated method stub
		return coronaRepo.insertVaccine(price, required_doses, req_no, company, country, name);
	}

	@Override
	public int updateVaccineDetails(Double price, Long req_no, String company, String country, String name) {
		// TODO Auto-generated method stub
		return coronaRepo.updateRecords(price, req_no, company, country, name);
	}

	@Override
	public Date fetchSystemDate() {
		// TODO Auto-generated method stub
		return coronaRepo.getSystemDate();
	}
	
	


	
	
	


	

}
