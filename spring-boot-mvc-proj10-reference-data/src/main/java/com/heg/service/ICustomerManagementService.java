package com.heg.service;

import java.util.List;
import java.util.Set;

public interface ICustomerManagementService {
	
	public Set<String> getAllCountries();
	
	public Set<String> getAllLanguages();
	
	public List<String> getStateByCountry(String country);

}
