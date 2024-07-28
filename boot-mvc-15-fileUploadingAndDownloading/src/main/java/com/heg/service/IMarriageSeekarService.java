package com.heg.service;

import com.heg.entity.MarriageSeekerInfo;


public interface IMarriageSeekarService {	
	public String registerProfile(MarriageSeekerInfo entity);
	
	public Iterable<MarriageSeekerInfo> getAllProfiles();
}
