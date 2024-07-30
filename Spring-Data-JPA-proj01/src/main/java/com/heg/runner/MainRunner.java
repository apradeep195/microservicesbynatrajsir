package com.heg.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.heg.entity.CoronaVaccine;
import com.heg.service.ICoronaVaccineMgmtService;

@Component
public class MainRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineMgmtService coronaService;

	@Override
	public void run(String... args) throws Exception {
		
		
		

		/*
		 * try {
		 * 
		 * // create Entity class obj CoronaVaccine vaccine = new CoronaVaccine(null,
		 * "COVISHIELD", "manufactured by Serum Institute of India Pvt Ltd", "India",
		 * 61.0, 2);
		 * 
		 * // call business method
		 * System.out.println(coronaService.registerVaccine(vaccine));
		 * 
		 * } catch (DataAccessException dae) { dae.printStackTrace();
		 * 
		 * }
		 */

		// BULK INSERTION
		/*
		 * try {
		 * 
		 * Iterable<CoronaVaccine> listCoronaVaccines=
		 * coronaService.resistereInBatch(List.of( new CoronaVaccine(null, "Corbevax",
		 * "Biological E Limited", "India", 305.5, 1) , new CoronaVaccine(null,
		 * "ZyCoV-D", "Zydus Cadila", "India", 326.0, 3), new CoronaVaccine(null,
		 * "GEMCOVAC-19", "Gennova Biopharmaceuticals Limited", "India", 987.0, 1)));
		 */

		// Another way to make list

		/*
		 * Iterable<CoronaVaccine> listCoronaVaccines=
		 * coronaService.resistereInBatch(Arrays.asList( new CoronaVaccine(null,
		 * "Corbevax-1", "Biological E Limited-1", "India-1", 305.5, 1) , new
		 * CoronaVaccine(null, "ZyCoV-D-1", "Zydus Cadila", "India-1", 326.0, 3), new
		 * CoronaVaccine(null, "GEMCOVAC-19-1", "Gennova Biopharmaceuticals Limited-1",
		 * "India-1", 987.0, 1)));
		 * 
		 * listCoronaVaccines.forEach(vaccine->System.out.println(vaccine.getReqNo()));
		 * 
		 * } catch (DataAccessException dae) { dae.printStackTrace();
		 * 
		 * 
		 * 
		 * }
		 */

		System.out.println("======================RECORDS COUNT==================");
		try {

			System.out.println(coronaService.getVaccinesCount());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("======================CHECK AVAILABILITY COUNT==================");

		try {
			Long vaccineNO = 6l;
			boolean isA = coronaService.checkVaccineAvailability(vaccineNO);
			System.out.println("VACCINE IS AVAILABLE OF NO " + vaccineNO + " is availe " + isA);
		} catch (DataAccessException dae) {

		}
	
		System.out.println();
		System.out.println("======================MANY WAYS TO GET LIST ==================");		
		Iterable<CoronaVaccine> listVaccines=	coronaService.fetchAllDetails();
	
		System.out.println();
		System.out.println("======================WAY FIRST ==================");
		System.out.println();
		for(CoronaVaccine vac : listVaccines) {
		System.out.println(vac);
		}
	
	System.out.println();
	System.out.println("======================WAY SECOND==================");
	System.out.println();
	coronaService.fetchAllDetails().forEach(vaccine->System.out.println(vaccine));
	
	System.out.println();
	System.out.println("======================USING LAMBDA==================");
	System.out.println();
	listVaccines.forEach(vaccine->{
		System.out.println(vaccine);
	});
	
	System.out.println();
	System.out.println("======================USING STREAM==================");
	System.out.println();
	Arrays.asList(coronaService.fetchAllDetails()).stream().forEach(System.out::println);
	
	
	System.out.println();
	System.out.println("======================USING MAP==================");
	System.out.println();
	Arrays.asList(coronaService.fetchAllDetails()).stream().map(e1->e1).forEach(System.out::println);
	
	
	
	
	
	System.out.println();
	System.out.println("======================fecthAllByIds  MANY WAYS TO GET LIST ==================");		
	Iterable<CoronaVaccine> list= coronaService.fecthAllByIds(List.of(1l,5l));

	System.out.println();
	System.out.println("======================fecthAllByIds WAY FIRST ==================");
	System.out.println();
	for(CoronaVaccine vac : list) {
	System.out.println(vac);
	}

System.out.println();
System.out.println("====================== fecthAllByIds WAY SECOND==================");
System.out.println();
coronaService.fecthAllByIds(List.of(1l,5l)).forEach(vaccine->System.out.println(vaccine));

System.out.println();
System.out.println("======================fecthAllByIds USING LAMBDA==================");
System.out.println();
list.forEach(vaccine->{
	System.out.println(vaccine);
});

System.out.println();
System.out.println("======================fecthAllByIds USING STREAM==================");
System.out.println();
Arrays.asList(coronaService.fecthAllByIds(List.of(1l,5l))).stream().forEach(System.out::println);


System.out.println();
System.out.println("======================fecthAllByIds USING MAP==================");
System.out.println();
Arrays.asList(coronaService.fecthAllByIds(List.of(1l,5l))).stream().map(e1->e1).forEach(System.out::println);


	
	
	}
}
