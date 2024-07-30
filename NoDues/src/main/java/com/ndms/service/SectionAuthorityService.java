package com.ndms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndms.repository.SectionAuthorityRepository;

@Service
public class SectionAuthorityService {

	@Autowired
	private SectionAuthorityRepository section_Authority_Repository;
}
