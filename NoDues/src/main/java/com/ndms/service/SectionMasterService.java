package com.ndms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndms.repository.SectionMasterRepository;

@Service
public class SectionMasterService {
	
	@Autowired
private SectionMasterRepository section_Master_Repository;
}
