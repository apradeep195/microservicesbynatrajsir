package com.ndms.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.ndms.configurations.CustomAuthenticationProvider;


@Component
public class AuthenticationService {

	@Autowired
	private CustomAuthenticationProvider authenticationProvider;
	
public void doAutoLogin(String username, String password, HttpServletRequest request) {

try {
// Must be called from request filtered by Spring Security, otherwise SecurityContextHolder is not updated
UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
token.setDetails(new WebAuthenticationDetails(request));
Authentication authentication = this.authenticationProvider.authenticate(token);
SecurityContextHolder.getContext().setAuthentication(authentication);
} 
catch (Exception e) {
	e.printStackTrace();
SecurityContextHolder.getContext().setAuthentication(null);
}
}
}