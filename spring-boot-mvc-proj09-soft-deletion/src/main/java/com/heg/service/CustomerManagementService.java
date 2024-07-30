package com.heg.service;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service("custService")
public class CustomerManagementService implements ICustomerManagementService {

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
		// TODO Auto-generated method stub
		Locale[] locales = Locale.getAvailableLocales();
		Set<String> langaugesSet = new TreeSet<>();
		for (Locale l : locales) {
			langaugesSet.add(l.getDisplayLanguage());
		}

		return langaugesSet;
	}

}
