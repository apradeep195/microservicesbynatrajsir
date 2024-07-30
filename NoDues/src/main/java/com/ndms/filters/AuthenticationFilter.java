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

import com.ndms.dto.EmployeeRoleDTO;
import com.ndms.excetion.AnonymousUserException;
import com.ndms.service.CurrentUserService;
import com.ndms.service.EmployeeRoleService;

@Component
@Order(1)
public class AuthenticationFilter implements Filter {

	@Value("${server.servlet.context-path}")
	private String contextPath;
	
	@Autowired
	EmployeeRoleService empRoleService;

	@Autowired
	CurrentUserService currentUserService;
	
	private static final Logger logger =LogManager.getLogger(AuthenticationFilter.class);
		
public AuthenticationFilter() {
}

@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

	HttpSession session;
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    EmployeeRoleDTO empRole=null;
    
    if(!request.getRequestURI().contains("login") && !request.getRequestURI().contains("css") && !request.getRequestURI().contains("js") && !request.getRequestURI().contains("images_st") ) {
	try {
		empRole = empRoleService.getEmployeRoleInfo(currentUserService.getCurrentUserId()+"");
	}
	catch (AnonymousUserException ex) {
		  ex.printStackTrace();
		  response.sendRedirect("error/500");		  
	}
	catch (InstantiationException | IllegalAccessException e) {
		e.printStackTrace();
	}
     request.getSession().setAttribute("ROLE", empRole.getRole());
    }
     
     chain.doFilter(req, res);
}

@Override
public void init(FilterConfig filterConfig) {
}

@Override
public void destroy() {


}



}