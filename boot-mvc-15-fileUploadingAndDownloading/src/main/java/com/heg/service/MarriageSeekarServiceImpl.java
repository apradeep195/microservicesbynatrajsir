package com.heg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heg.entity.MarriageSeekerInfo;
import com.heg.repo.IMarriageSeekerInfoRepo;

@Service("seekerService")
public class MarriageSeekarServiceImpl implements IMarriageSeekarService {
	@Autowired
	private IMarriageSeekerInfoRepo repo;

	@Override
	public String registerProfile(MarriageSeekerInfo entity) {
		// TODO Auto-generated method stub
		return "Profile Registered with Id " +repo.save(entity).getProfileId();
	}

	@Override
	public Iterable<MarriageSeekerInfo> getAllProfiles() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
}
