package com.heg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heg.entity.Person;
import com.heg.repository.IPersonRepo;

@Service("personService")
public class PersonMgmtServiceImpl implements IPersonMgmtService {

	@Autowired
	private IPersonRepo perRepo;
	
	
	@Autowired
	private IPersonRepo phoneRepo;
	
	@Override
	public String savePerson(Person per) {
		// TODO Auto-generated method stub
		int idVal=perRepo.save(per).getPid();
		
		return "Person and Phone Numbers are saved with the ID values "+idVal;
	}

	@Override
	public Iterable<Person> fetchByPerson() {
		// TODO Auto-generated method stub
		return perRepo.findAll();
	}

}
