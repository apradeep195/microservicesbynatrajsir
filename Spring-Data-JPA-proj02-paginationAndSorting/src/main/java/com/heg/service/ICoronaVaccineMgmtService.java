package com.heg.service;

import java.util.List;
import java.util.Optional;

import com.heg.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService{
	
	public String  registerVaccine(CoronaVaccine vaccine);
	
	public Iterable<CoronaVaccine> resistereInBatch(Iterable<CoronaVaccine> listVaccine);
	
	public Long getVaccinesCount();
	
	public boolean checkVaccineAvailability(Long reqNo);
	
	public Iterable<CoronaVaccine> fetchAllDetails();	

	public Iterable<CoronaVaccine> fecthAllByIds(List<Long> ids);
	
	public Optional<CoronaVaccine> fetchById(Long id);

	

}
