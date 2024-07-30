package com.ndms.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.ndms.excetion.AnonymousUserException;
import com.ndms.utils.ROLE;

@Component
public class CurrentUserService {

	private static final Logger logger=LogManager.getLogger(CurrentUserService.class);
	
	public String  getCurrentUsername() {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		 String username="";		
		if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		} else {
		   username = principal.toString();
		}
		return username;
	}
	
	public Long  getCurrentUserId() {		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 String username="";		
		if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		} else {
		   username = principal.toString();
		}
		if(username==null || username.equals("anonymousUser"))
		   	  throw new AnonymousUserException("User is not found or session might be expired.");
		
		return Long.parseLong(username);
	}
	
	
public UserDetails  getCurrentUser() {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		UserDetails userDetails=null;
		
		if (principal instanceof UserDetails) {
			userDetails = ((UserDetails)principal);
		} 
		
		return userDetails;
	}

public Boolean isAuthenticated() {	
 return	SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
}

public boolean checkifUserHasRole(ROLE role) {
	
	List<GrantedAuthority> authorities = (List<GrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();

    for (GrantedAuthority grantedAuthority : authorities) {
    	logger.debug("Authority   "+grantedAuthority.getAuthority());
        if (role.getValue().equals(grantedAuthority.getAuthority())) {
            return true;
        }
    }
    return false;
}
}
