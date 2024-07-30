package com.heg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heg.repo.ICoronaVaccineRepo;
import com.heg.views.View;

@Service("vaccineMgmtService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo coronaRepo;

	@Override
	public <T extends View> List<T> searchVaccineByComapny(String company, Class<T> clazz) {
		// TODO Auto-generated method stub
		return coronaRepo.findByCompanyOrderByCompanyDesc(company, clazz);
	}

	
	


	

}
