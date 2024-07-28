package com.heg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heg.model.Faculity;
import com.heg.repo.IFaculityRepo;

@Service("trainingMgmtService")
public class TrainingInsituteServiceImpl implements ITrainingInsituteService {

	@Autowired
	private IFaculityRepo repo;
	
	@Override
	public List<Faculity> getAllFaculity() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
