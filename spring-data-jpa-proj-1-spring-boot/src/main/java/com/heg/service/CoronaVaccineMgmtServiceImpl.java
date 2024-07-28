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
		// TODO Auto-generated method stub
		System.out.println("inMemory proxy class name ::"+coronaRepo.getClass());
		//use repo
		CoronaVaccine savedVaccine= null;
		if(vaccine!=null)
		 savedVaccine= coronaRepo.save(vaccine);
		
		return savedVaccine!=null?"Vaccine registred/Updation successfully successfull with "+savedVaccine.getRegNo(): "Vaccine Registration/Updation failed";
	}

	@Override
	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccines) {
		// TODO Auto-generated method stub
		
		if(vaccines!=null)		
		return coronaRepo.saveAll(vaccines);
		else 
			throw  new IllegalArgumentException("batch insertion not done");
	}

	@Override
	public long getVaccinesCount() {
		// TODO Auto-generated method stub
		return coronaRepo.count();
	}

	@Override
	public boolean checkAvaililityByReqId(long reqId) {
		// TODO Auto-generated method stub
		return coronaRepo.existsById(reqId);
	}

	@Override
	public Iterable<CoronaVaccine> fetchAllDetails() {
		// TODO Auto-generated method stub
		return coronaRepo.findAll();
	}

	@Override
	public Iterable<CoronaVaccine> fetchAllDetailsByIds(List<Long> ids) {
		// TODO Auto-generated method stub
		return coronaRepo.findAllById(ids);
	}

	@Override
	public Optional<CoronaVaccine> fetchVaccineByID(Long reqNo) {
		// TODO Auto-generated method stub
		return coronaRepo.findById(reqNo);
	}

	@Override
	public String removeVaccineById(Long reqNo) {
		Optional<CoronaVaccine> opt= coronaRepo.findById(reqNo);
		if(opt.isPresent()) {
			coronaRepo.deleteById(reqNo);
			return  "record deleted having id :: " +reqNo;
			
		}  else {
			return "record not found  having id :: " +reqNo;
		}
		
	}
	

}
