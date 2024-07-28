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
		
		/*try {

			Iterable<CoronaVaccine> listEntities=service.fetchDetails(false, "price");
			listEntities.forEach(System.out::println);
		}catch(DataAccessException dae) {
			
		} */
		
		try {
			service.fetchDetailsByPageNo(0,25, false, "price").forEach(System.out::println);
			
		}catch(DataAccessException dae) {
			
		}
		
	}
	
	

}
