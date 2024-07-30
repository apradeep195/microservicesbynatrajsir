package com.ndms.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ndms.dto.EmployeeRoleDTO;
import com.ndms.dto.LoginDTO;
import com.ndms.service.AuthenticationService;
import com.ndms.service.CurrentUserService;
import com.ndms.service.EmployeeRoleService;

@Controller
public class LoginController {

	@Autowired
	private HttpServletRequest httpServletRequest;
	@Autowired
	private CurrentUserService currentUserService;
	@Autowired
	public AuthenticationService authService;
	
	@Autowired
	public EmployeeRoleService empRoleSerivce;

	
	private static final Logger logger=LogManager.getLogger(LoginController.class); 
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String login(@ModelAttribute LoginDTO loginDto) throws InstantiationException, IllegalAccessException {
		
		EmployeeRoleDTO empRole=empRoleSerivce.getEmployeRoleInfo(loginDto.getUserId()+"");
		
		
		if(empRole!=null && loginDto.getPassword().equals("123e4567-e89b-42d3-a456-556642440000")) {			
			httpServletRequest.getSession().setAttribute("userid",loginDto.getUserId());
			authService.doAutoLogin(loginDto.getUserId()+"",loginDto.getPassword() ,httpServletRequest);
			
          if(loginDto.getPath()==null) {
	    	   if(empRole.getRole().contains("INITIATE")) {
					return "redirect:/initiate/all";
				}
				else if(empRole.getRole().contains("HOD")) {
					return "redirect:/hod/all";
				}
				else if(empRole.getRole().contains("ADMIN")) {
					return "redirect:/hr/all";
				}
				else if(empRole.getRole().contains("SECTION")) {
					return "redirect:/section/all";
				}else {
					return "http://192.168.9.111/employee.jsp";
				}	
		   }
	       else {
	    		   if(loginDto.getPath().equalsIgnoreCase("INITIATE")) {
						return "redirect:/initiate/all";
					}					
					else if(loginDto.getPath().equalsIgnoreCase("HOD")) {
						return "redirect:/hod/all";
					}
					else if(loginDto.getPath().equalsIgnoreCase("ADMIN")) {
						return "redirect:/hr/all";
					}
					else if(loginDto.getPath().equalsIgnoreCase("SECTION")) {
						return "redirect:/section/all";
					}else {
						return "http://192.168.9.111/employee.jsp";
					}		
	    	   }
		}
		else {
			return "http://192.168.9.111/employee.jsp";
		}

	}
	
	@RequestMapping(value = "/invalidate",method = RequestMethod.GET)
	public String invalidate()
	{
		logger.debug("invalidate called ");

		httpServletRequest.getSession().removeAttribute("userid");
		httpServletRequest.getSession().removeAttribute("ROLE");
		httpServletRequest.getSession().invalidate();
		
		 return "redirect:http://192.168.9.111/employee.jsp";
		
	}
	
	
}
