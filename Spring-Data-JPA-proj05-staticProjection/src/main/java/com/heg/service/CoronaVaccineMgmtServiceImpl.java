package com.heg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heg.entity.CoronaVaccine;
import com.heg.repo.ICoronaVaccineRepo;
import com.heg.views.ResultView;

@Service("vaccineMgmtService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo coronaRepo;

	@Override
	public List<ResultView> searchVaccineByStartPrice(double startPrice) {
		// TODO Auto-generated method stub
		return coronaRepo.findByPriceGreaterThanEqualOrderByPrice(startPrice);
	}

	
	


	

}
