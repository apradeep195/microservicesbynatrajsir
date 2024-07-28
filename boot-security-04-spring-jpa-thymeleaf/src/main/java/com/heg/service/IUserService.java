package com.heg.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.heg.model.UserDetails;

public interface IUserService extends UserDetailsService {

	public String register(UserDetails details);
}
