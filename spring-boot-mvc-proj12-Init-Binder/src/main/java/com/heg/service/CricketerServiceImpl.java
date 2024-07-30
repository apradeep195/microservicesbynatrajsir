package com.heg.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.heg.model.Cricketer;
import com.heg.repo.ICricketerRepo;

public class CricketerServiceImpl implements ICricketerService {

	@Autowired
	private ICricketerRepo repo;
	@Override
	public String registerCrickter(Cricketer cricketer) {
		// TODO Auto-generated method stub
		return "Cricketer is Registered with "+repo.save(cricketer).getCid() ;
	}

}
