package com.snowsec0.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class XssController {
	
	@RequestMapping("getinfo")
	public String submit(@RequestParam(name = "user", required = false, defaultValue = "admin") String user)
	{
		System.out.println("welcome "+user);
		return "welcome "+user;
	}

}
