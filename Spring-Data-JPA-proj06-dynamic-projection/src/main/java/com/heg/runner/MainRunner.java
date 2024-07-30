package com.heg.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.heg.service.ICoronaVaccineMgmtService;
import com.heg.views.ResultView1;
import com.heg.views.ResultView2;
import com.heg.views.ResultView3;

@Component
public class MainRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineMgmtService coronaService;

	@Override
	public void run(String... args) throws Exception {

		System.out.println();
		System.out.println("=====================================");
		coronaService.searchVaccineByComapny("Bharat Bio-Tech", ResultView1.class).forEach(vaccine->System.out.println(vaccine.getName() +" =========== " + vaccine.getCountry()));
		
		System.out.println();
		System.out.println("=====================================");
		
		coronaService.searchVaccineByComapny("Bharat Bio-Tech", ResultView2.class).forEach(vaccine->System.out.println(vaccine.getPrice() +" =========== " + vaccine.getReqNo()));
		
		System.out.println();
		System.out.println("=====================================");
		
		coronaService.searchVaccineByComapny("Bharat Bio-Tech", ResultView3.class).forEach(vaccine->System.out.println(vaccine.getPrice() +" =========== " + vaccine.getReqNo() + " ========= " +vaccine.getName() + " ========= " +vaccine.getCountry()));
		
		System.out.println();
		
	}
	
}
