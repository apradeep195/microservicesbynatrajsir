package com.heg.service;

import java.util.List;

import com.heg.views.ResultView;

public interface ICoronaVaccineMgmtService{
	
	public List<ResultView> searchVaccineByStartPrice(double startPrice);

}
