package com.heg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heg.model.Cricketer;
import com.heg.repo.ICricketerRepo;

@Service("cricketerService")
public class CrickerterMgmtServiceImpl implements ICrickerterMgmtService {

	@Autowired
	private ICricketerRepo repo;
	@Override
	public String registerCricketer(Cricketer cricket) {
		// TODO Auto-generated method stub
		return "Cricketer is register " +repo.save(cricket).getCid();
	}

}
