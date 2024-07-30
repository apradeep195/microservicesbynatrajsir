package com.heg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heg.entity.MarriageSeeker;
import com.heg.repository.IMarraigeSeekarRepo;

@Service("matrimonyService")
public class MatrimonyServiceMgmtImpl implements IMatrimonyServiceMgmt {

	@Autowired
	private IMarraigeSeekarRepo msRepo;
	
	
	@Override
	public String registerMarriageSeeker(MarriageSeeker seekar) {
		// TODO Auto-generated method stub
		return "MARRIAGE INFO HAS BEEN SAVED WITH ID " +msRepo.save(seekar).getId();
	}

}
