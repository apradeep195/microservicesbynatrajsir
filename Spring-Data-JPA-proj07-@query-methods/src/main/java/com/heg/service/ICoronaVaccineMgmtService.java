package com.heg.service;



import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.heg.entity.CoronaVaccine;



public interface ICoronaVaccineMgmtService{
	
	public List<CoronaVaccine> fetchVaccineByComapny(String company);
	
	@Transactional
	public int updatePriceByCountry(double price,String country);
	
	@Transactional
	public int deleteVaccineByPrice(double startPrice,double endPrice);
	
	
	public int registerVaccine(Double price,int  required_doses, Long req_no,String  company,String  country,String name);
	
	public int updateVaccineDetails(Double price, Long req_no,String  company,String  country,String name);
	
	public Date fetchSystemDate();

}
