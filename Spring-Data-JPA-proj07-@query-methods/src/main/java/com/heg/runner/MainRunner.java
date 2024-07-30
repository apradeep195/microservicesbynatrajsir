package com.heg.runner;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.heg.service.ICoronaVaccineMgmtService;

@Component
public class MainRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineMgmtService coronaService;

	@Override
	public void run(String... args) throws Exception {

	//coronaService.fetchVaccineByComapny("Biological E Limited").forEach(System.out::println); 
		
//	int cnt=	coronaService.updatePriceByCountry(500.5, "India-1");
//	System.out.println("UPDATED RECORDS COUNT " +cnt);
		
		//int cnt =coronaService.deleteVaccineByPrice(500.0, 600.0);
		//System.out.println("RECORDS HAS BEEN DELETED " +cnt);
		
		//NATIVE INSERT SQL DELETED
		
		/*int cnt =coronaService.registerVaccine(500.5, 2, null, "TEST COMPANY -6 ", "INDIA","VACCINE -6");
		if(cnt==1) {
			System.out.println("RECORDS SAVED SUCCESSFULLY");
		}else {
			System.out.println("SOME ERROR OCCURED WHILE TRYING TO INSERT RECORDS ");
		}*/
		
		//price, req_no, company, country, name
		/*coronaService.updateVaccineDetails(600.5,1l, "Serum Institute of India", "INDIA","COVOVAX ");
		coronaService.updateVaccineDetails(380.5,2l, "Nuvaxovid", "INDIA","Novavax ");
		coronaService.updateVaccineDetails(170.5,3l, "SK Bioscience", "INDIA","SK Bioscience ");
		coronaService.updateVaccineDetails(1930.5,4l, "Spikevax", "INDIA","Moderna ");
		coronaService.updateVaccineDetails(6511.5,5l, "Comirnaty", "Comirnaty","Pfizer ");
		coronaService.updateVaccineDetails(6511.5,6l, "Convidecia", "Convidecia","CanSino ");
		coronaService.updateVaccineDetails(6511.5,7l, "Johnson & Johnson", "Johnson & Johnson","Janssen  ");
		coronaService.updateVaccineDetails(6511.5,8l, "Oxford", "Oxford","AstraZeneca  ");
		coronaService.updateVaccineDetails(600.5,9l, "Serum Institute of India", "INDIA","COVOVAX ");
		coronaService.updateVaccineDetails(380.5,10l, "Nuvaxovid", "INDIA","Novavax ");
		coronaService.updateVaccineDetails(170.5,11l, "SK Bioscience", "INDIA","SK Bioscience "); */
		
		
		Date dt= coronaService.fetchSystemDate();
		System.out.println("=====DATE===========" +dt);
		
	}
	
}
