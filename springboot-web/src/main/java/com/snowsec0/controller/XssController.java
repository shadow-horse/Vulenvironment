package com.snowsec0.controller;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping("update")
	public String update(@RequestParam(name = "domxss4", required = false, defaultValue = "") String domxss4)
	{
		return domxss4;
	}
	
	@RequestMapping("redirect")
	public String redirect(HttpServletRequest request,@RequestParam(name = "redirect", required = false, defaultValue = "") String redirect)
	{
		String urls = request.getRequestURL().toString();
		if(redirect.indexOf(":") != -1)
		{
			return redirect;
		}
		
		urls = urls.substring(0,urls.lastIndexOf("/")) + "/" +redirect;
		
		return urls;
	}
}
