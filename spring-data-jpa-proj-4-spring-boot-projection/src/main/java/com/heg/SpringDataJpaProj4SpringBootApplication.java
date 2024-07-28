package com.heg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.heg.entity.CoronaVaccine;
import com.heg.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class SpringDataJpaProj4SpringBootApplication {

	public static void main(String[] args) {
	 
		SpringApplication.run(SpringDataJpaProj4SpringBootApplication.class, args);
	
	
	}

}
