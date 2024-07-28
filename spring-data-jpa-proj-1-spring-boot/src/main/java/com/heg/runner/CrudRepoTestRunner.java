package com.heg.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.heg.entity.CoronaVaccine;
import com.heg.service.ICoronaVaccineMgmtService;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("RECORDS COUNT " +service.getVaccinesCount());
		
	/*	try {
			
			System.out.println("VACINE IS AVAIABLE OR NOT " +service.checkAvaililityByReqId(6l));
		}catch(DataAccessException ade) {
			ade.printStackTrace();
			
		}
		
		
		System.out.println("================FINDALL RECORDS============================");
		Iterable<CoronaVaccine> itList= service.fetchAllDetails();
		itList.forEach(vaccine->{
			System.out.println(vaccine);
		});
		
		System.out.println("=============SECOND WAY FIND ALL ===========");
		service.fetchAllDetails().forEach(vaccine->System.out.println(vaccine));
		
		System.out.println("===========THIRD WAY FETCH ALL====================");
		service.fetchAllDetails().forEach(System.out::println);
		
		System.out.println("============LAMDA API USING=================");
		Arrays.asList(service.fetchAllDetails()).forEach(System.out::println);
		
		System.out.println("============USING LAMBDA API==================");
		Arrays.asList(service.fetchAllDetails()).stream().map(s1->s1).forEach(System.out::println);
		
		*/
		
		
		
		
		
	/*	try {
			System.out.println("==========FIND ALL BY ID==============");
			Iterable<CoronaVaccine> itrConaVaccine= service.fetchAllDetailsByIds(List.of(1l,3l));
			itrConaVaccine.forEach(vaccine->{
				System.out.println(vaccine);
			});
			
			System.out.println();
			System.out.println("============2nd Way to FIND ALL BY ID=============");
			service.fetchAllDetailsByIds(List.of(1l,5l)).forEach(vaccine->System.out.println(vaccine));
			
			System.out.println();
			System.out.println("============3nd Way to FIND ALL BY ID METHOD REFERENCE=============");
			service.fetchAllDetailsByIds(List.of(1l,2l)).forEach(System.out::println);
			
			System.out.println();
			System.out.println("============4nd Way to FIND ALL BY ID STREAM API=============");
			Arrays.asList(service.fetchAllDetailsByIds(List.of(1l,4l))).stream().map(s1->s1).forEach(System.out::println);
			
			System.out.println();
			System.out.println("============3nd Way to FIND ALL BY ID METHOD REFERENCE=============");
			Arrays.asList(service.fetchAllDetailsByIds(List.of(3l,5l))).stream().forEach(System.out::println);
			
			
		}catch(DataAccessException dae) {
			System.out.println(dae);
			dae.printStackTrace();
		}
		*/
		
		
	/*	try {	
		System.out.println("==========FIND BY ID=================");
		Optional<CoronaVaccine> opt=service.fetchVaccineByID(60l);
		if(opt.isPresent()) {
			System.out.println(opt.get());
		}else {
			System.out.println("RECORD NOT FOUND");
		}
	}catch(DataAccessException dae) {
		System.out.println(dae);
		dae.printStackTrace();
	}*/
		
		
		// Batch insertion
		try {
		Iterable<CoronaVaccine> listVaccines=service.registerInBatch(List.of( new CoronaVaccine(null,"sputni1","Russie","Russi",500.2,2), 
																			 new CoronaVaccine(null,"pyzer1","pyzer","USA",710.6,2), 
																			 new CoronaVaccine(null,"pyzer2","pyzer","USA",720.6,2), 
																			 new CoronaVaccine(null,"pyzer3","pyzer","USA",730.6,2), 
																			 new CoronaVaccine(null,"pyzer4","pyzer","USA",740.6,2), 
																			 new CoronaVaccine(null,"pyzer5","pyzer","USA",750.6,2), 
																			 new CoronaVaccine(null,"pyzer6","pyzer","USA",760.6,2), 
																			 new CoronaVaccine(null,"pyzer7","pyzer","USA",770.6,2), 
																			 new CoronaVaccine(null,"pyzer8","pyzer","USA",780.6,2), 
																			 new CoronaVaccine(null,"pyzer9","pyzer","USA",790.6,2), 
																			 new CoronaVaccine(null,"pyzer10","pyzer","USA",7100.6,2), 
																			 new CoronaVaccine(null,"pyzer11","pyzer","USA",7110.6,2), 
																			 new CoronaVaccine(null,"pyzer12","pyzer","USA",7120.6,2), 
																			 new CoronaVaccine(null,"pyzer13","pyzer","USA",7130.6,2), 
																			 new CoronaVaccine(null,"pyzer14","pyzer","USA",7140.6,2), 
																			 new CoronaVaccine(null,"pyzer15","pyzer","USA",7150.6,2), 
																			 new CoronaVaccine(null,"pyzer16","pyzer","USA",7160.6,2), 
																			 new CoronaVaccine(null,"pyzer17","pyzer","USA",7170.6,2), 																			 
																			 new CoronaVaccine(null,"Moderana1","Moderana","USA",510.9,2)				
				));
		System.out.println("The regNo are : ");
		listVaccines.forEach(vaccine->System.out.println(vaccine.getRegNo()));
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		try {
			//Create entity class object
			CoronaVaccine vaccin=new CoronaVaccine(null,"TEST","TEST-INSITITUE","INDIA",800.0,5);
	//call b.method
			System.out.println(service.registerVaccine(vaccin));
		}catch(DataAccessException dae) {
			
		}
		
	/*	CoronaVaccine vaccine=service.fetchVaccineByID(2L).orElseThrow(()->new IllegalArgumentException("NOT AVAILABLE"));
		System.out.println(vaccine);
		System.out.println("=========================================");
		
		try {
			System.out.println(service.removeVaccineById(2l));
			
		}catch(DataAccessException dae) {
			
		}
		*/
		
		
		
		
	}
	
	

}
