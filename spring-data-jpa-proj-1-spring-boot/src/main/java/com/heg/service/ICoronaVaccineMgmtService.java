package com.heg.service;

import java.util.List;
import java.util.Optional;

import com.heg.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {

	public String registerVaccine(CoronaVaccine vaccine);
	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccines);
	public long getVaccinesCount();
	public boolean checkAvaililityByReqId(long reqId);
	public Iterable<CoronaVaccine> fetchAllDetails();
	public Iterable<CoronaVaccine> fetchAllDetailsByIds(List<Long> ids);
	public Optional<CoronaVaccine> fetchVaccineByID(Long reqNo);
	public String removeVaccineById(Long reqNo);
}
