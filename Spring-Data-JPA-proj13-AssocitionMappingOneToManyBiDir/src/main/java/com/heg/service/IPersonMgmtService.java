package com.heg.service;

import com.heg.entity.Person;

public interface IPersonMgmtService {

	public String savePerson(Person per);
	
	public Iterable<Person> fetchByPerson();
}
