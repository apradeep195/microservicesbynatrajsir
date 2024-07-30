package com.heg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.heg.service.IWishMessageService;

@Controller
public class WishMessageGenerator {

	@Autowired
	private IWishMessageService service;
	
	@RequestMapping("/")
	public String showHome() {
		return "home"; //Logical view Name
	}
	
	//Legancy Approch
	@RequestMapping("/wish1")
	public ModelAndView generateMessage1() {
		//Use Service
		String result=service.generateWishMessage();
		//return MAV (Model and View)
		
/*		ModelAndView mav=new ModelAndView();
		mav.addObject("wMsg",result);  //Like this we can add  any no of model attributes 
		mav.setViewName("display");
		return mav; 
		*/
		
		return new ModelAndView("display","wMsg",result); //here we can add only one model attribute
	}
	
/*	@RequestMapping("/wish")
	public String generateMessage(BindingAwareModelMap bindingAwareMap) {
		//Use Service
		System.out.println("Dispatcher Servlet Internally Class Name ===" +bindingAwareMap.getClass().getName());
		String result=service.generateWishMessage();
		//return MAV (Model and View)
		bindingAwareMap.addAttribute("wMsg",result);		
		return "display"; //here we can add only one model attribute
	} */
	
	/*@RequestMapping("/wish")
	public String generateMessage(ModelMap bindingAwareMap) {
		//Use Service
		System.out.println("Dispatcher Servlet Internally Class Name ===" +bindingAwareMap.getClass().getName());
		String result=service.generateWishMessage();
		//return MAV (Model and View)
		bindingAwareMap.addAttribute("wMsg",result);		
		return "display"; //here we can add only one model attribute
	}
	*/
	
/*	@RequestMapping("/wish")
	public String generateMessage(HashMap<String, Object> bindingAwareMap) {
		//Use Service
		System.out.println("Dispatcher Servlet Internally Class Name ===" +bindingAwareMap.getClass().getName());
		String result=service.generateWishMessage();
		//return MAV (Model and View)
		bindingAwareMap.put("wMsg",result);		
		return "display"; //here we can add only one model attribute
	}
	*/
	
	/*@RequestMapping("/wish")
	public String generateMessage(Map<String, Object> bindingAwareMap) {
		//Use Service
		System.out.println("Dispatcher Servlet Internally Class Name ===" +bindingAwareMap.getClass().getName());
		String result=service.generateWishMessage();
		//return MAV (Model and View)
		bindingAwareMap.put("wMsg",result);		
		return "display"; //here we can add only one model attribute
	}
	*/
	
	
	/*
	@RequestMapping("/wish")
	public String generateMessage(Model model) {
		//Use Service
		System.out.println("Dispatcher Servlet Internally Class Name ===" +model.getClass().getName());
		String result=service.generateWishMessage();
		//return MAV (Model and View)
		model.addAttribute("wMsg",result);		
		return "display"; //here we can add only one model attribute
	}*/
	
	
	/*
	  @RequestMapping("/wish")
	public void generateMessage(Model model) {
		//Use Service
		System.out.println("Dispatcher Servlet Internally Class Name ===" +model.getClass().getName());
		String result=service.generateWishMessage();
		//return MAV (Model and View)
		model.addAttribute("wMsg",result);		
		//return "display"; //here we can add only one model attribute
	}
	 */
	 
	 
	@RequestMapping("/wish")
	public Model generateMessage() {
		//Use Service
		Model model=new ExtendedModelMap();
		String result=service.generateWishMessage();
		//return MAV (Model and View)
		model.addAttribute("wMsg",result);		
		return model;

	}
	
}
