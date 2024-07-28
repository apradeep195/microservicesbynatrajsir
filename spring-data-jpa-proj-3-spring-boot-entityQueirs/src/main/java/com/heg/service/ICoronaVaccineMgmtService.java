package com.heg.service;

import java.util.List;

import com.heg.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	
	public List<CoronaVaccine> fetchVaccineByCompany(String company);
}
