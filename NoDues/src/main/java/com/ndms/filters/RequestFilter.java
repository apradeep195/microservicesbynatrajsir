package com.ndms.filters;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ndms.service.AuthenticationService;
import com.ndms.service.CurrentUserService;
import com.ndms.service.EmployeeRoleService;
import com.ndms.utils.CommonUtils;

@Component
@Order(0)
public class RequestFilter implements Filter {

	@Value("${server.servlet.context-path}")
	private String contextPath;
	
	@Autowired
	AuthenticationService authenticationService;
	
	@Autowired
	CurrentUserService currentUserService;
	
	@Autowired
	EmployeeRoleService empRoleService;
	
	private static final Logger logger =LogManager.getLogger(RequestFilter.class);
		
public RequestFilter() {
}

@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	HttpSession session;
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
   chain.doFilter(req, res);
   
}

@Override
public void init(FilterConfig filterConfig) {
}

@Override
public void destroy() {


}



}
