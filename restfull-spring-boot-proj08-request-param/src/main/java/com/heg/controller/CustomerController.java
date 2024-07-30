package com.heg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@GetMapping("/report")
	public String showData(@RequestParam("cno") Integer no,
							@RequestParam(required = false) String cname) {
		return no + "     " +cname;
	}
}
