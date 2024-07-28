package com.heg.service;

import java.util.List;

import com.heg.entity.CoronaVaccine;
import com.heg.type.ResultView;

public interface ICoronaVaccineMgmtService {
	
	public List<ResultView> searchVaccinesByStartPrice(double price);
}
