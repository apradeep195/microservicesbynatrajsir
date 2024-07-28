package com.heg;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.heg.model.Cricketer;
import com.heg.service.ICrickerterMgmtService;

@Controller
public class CricketerController {

	@Autowired
	private ICrickerterMgmtService service;
	
	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/register_Cricketer")
	public String showCricketerRegistrationPage(@ModelAttribute("crickt") Cricketer crickt) {
		
		
		return "register";
	}
	
	@PostMapping("/register_Cricketer")
	public String registerCricketr(Map<String,Object> map,
									@ModelAttribute("crickt") Cricketer crickt, 
									BindingResult errors) {
		
		String result= service.registerCricketer(crickt);
		map.put("resultMsg", result);
		
		return "show_result";
	}
	
	@InitBinder
	public void myInitBinder(WebDataBinder binder) {
		System.out.println("Cricketer Controller . myInitBinde()");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");		
		CustomDateEditor editor= new CustomDateEditor(sdf, false); //ReadyMade PropertyEditor to convert String Date value to java.utilDate
		binder.registerCustomEditor(java.util.Date.class, editor);
	}
}
