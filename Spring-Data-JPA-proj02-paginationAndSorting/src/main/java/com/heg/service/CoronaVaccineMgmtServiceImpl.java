package com.heg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heg.entity.CoronaVaccine;
import com.heg.repo.ICoronaVaccineRepo;

@Service("vaccineMgmtService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo coronaRepo;

	@Override
	public String registerVaccine(CoronaVaccine vaccine) {
		System.out.println("In Memmory Proxy classess ");

		CoronaVaccine savedVaccine = null;
		if (vaccine != null)
			savedVaccine = coronaRepo.save(vaccine);
		return savedVaccine != null ? "VACCINE REGISTRED SUCCESSFULLY " + savedVaccine.getReqNo()
				: "ERROR OCCRED WHILE TRYING TO ADD VACCINE";
	}

	@Override
	public Iterable<CoronaVaccine> resistereInBatch(Iterable<CoronaVaccine> listVaccine) {
		System.out.println("IN MEMORY MANAGEMENT ");
		if(listVaccine !=null)
		return coronaRepo.saveAll(listVaccine);
		else 
			throw new IllegalArgumentException("BATCH InSERTION NOT DONE...........");
	}

	@Override
	public Long getVaccinesCount() {
		// TODO Auto-generated method stub
		return coronaRepo.count();
	}

	@Override
	public boolean checkVaccineAvailability(Long reqNo) {
		// TODO Auto-generated method stub
		return coronaRepo.existsById(reqNo);
	}

	@Override
	public Iterable<CoronaVaccine> fetchAllDetails() {
		// TODO Auto-generated method stub
		return coronaRepo.findAll();
	}

	@Override
	public Iterable<CoronaVaccine> fecthAllByIds(List<Long> ids) {
		// TODO Auto-generated method stub
		return coronaRepo.findAllById(ids);
	}

	@Override
	public Optional<CoronaVaccine> fetchById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	


	

}
