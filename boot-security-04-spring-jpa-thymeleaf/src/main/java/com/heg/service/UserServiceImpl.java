package com.heg.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.heg.model.UserDetails;
import com.heg.repo.IUserDetailsRepo;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDetailsRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public String register(UserDetails details) {
		details.setPwd(encoder.encode(details.getPwd()));
		return repo.save(details).getUid() + "User is registed";
	}

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		//get model class objecy (com.heg.mode.UserDetails)
	Optional<com.heg.model.UserDetails> opt=repo.findByUname(username);
	if(opt.isEmpty()) {
		throw new IllegalArgumentException("user not found ");
	}	else {
		com.heg.model.UserDetails details=opt.get();
		//convert Set<String> type roles Set<SGA> type roles
	/*	Set<GrantedAuthority> roles=new HashSet<>();
		for(String role : details.getRoles()) {
			SimpleGrantedAuthority authority=new SimpleGrantedAuthority(role);
			roles.add(authority);
		}
		
		//convert Model Class object (com.nt.model.userDetails obj) to spring security user object (org.springframework.security.user)
		User user=new User(details.getUname(),details.getPwd(),roles);
		
		*/
		
		
		//using lambda expression
		
		User user=new User(details.getUname(),
						  details.getPwd(), 
						  details.getRoles().stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
		
	
		return user;
	}
	}

}
