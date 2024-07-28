package com.heg.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.heg.service.ICoronaVaccineMgmtService;
import com.heg.type.ResultView;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		
	List<ResultView> listVaccines=service.searchVaccinesByStartPrice(500.0);
	listVaccines.forEach(vaccine->{
		System.out.println(vaccine.getName() + " COUNTRY " +vaccine.getCountry());
	});
	
	

}
	
}
