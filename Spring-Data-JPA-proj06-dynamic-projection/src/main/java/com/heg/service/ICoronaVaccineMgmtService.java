package com.heg.service;

import java.util.List;

import com.heg.views.View;



public interface ICoronaVaccineMgmtService{
	
	public <T extends View> List<T> searchVaccineByComapny(String company, Class<T> clazz);

}
