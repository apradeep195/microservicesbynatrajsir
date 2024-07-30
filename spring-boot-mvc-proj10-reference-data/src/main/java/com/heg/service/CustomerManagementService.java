package com.heg.service;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service("custService")
public class CustomerManagementService implements ICustomerManagementService {

	@Autowired
	private Environment env;
	
	@Override
	public Set<String> getAllCountries() {
		// TODO Auto-generated method stub
		Locale[] locales = Locale.getAvailableLocales();
		Set<String> countriesSet = new TreeSet<>();
		for (Locale l : locales) {
			countriesSet.add(l.getDisplayCountry());
		}

		return countriesSet;
	}

	@Override
	public Set<String> getAllLanguages() {
		
				Locale[] locales = Locale.getAvailableLocales();
				Set<String> languagesSet = new TreeSet<>();
				for (Locale l : locales) {
					languagesSet.add(l.getDisplayLanguage());
				}

				return languagesSet;
	}

	@Override
	public List<String> getStateByCountry(String country) {
		
		//get states from properties file using environment object		
		String statesInfo=env.getRequiredProperty(country);
		List<String> stateList=	Arrays.asList(statesInfo.split(","));		
		return stateList;
	}
	
	


}
