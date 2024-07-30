package com.heg.runner;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.heg.service.ICoronaVaccineMgmtService;
import com.heg.views.ResultView;



@Component
public class MainRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineMgmtService coronaService;
	


	@Override
	public void run(String... args) throws Exception {
		
		List<ResultView> resultList= coronaService.searchVaccineByStartPrice(500.0);
		resultList.forEach(vaccine->{
			System.out.println("Vaccine name " +vaccine.getName() + "Country Name  " +vaccine.getCountry());
		});
		

	
	
	}
}
