package com.heg.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.heg.model.Employee;

@Controller
public class TestController {

	@GetMapping("/data")
	public String bindData(Map<String,Object> map,
							@RequestParam("sno") Integer no,
							@RequestParam("sname") String name) {
		System.out.println(no + "  name ==  " +name);
		return "show_data";
	}
}
