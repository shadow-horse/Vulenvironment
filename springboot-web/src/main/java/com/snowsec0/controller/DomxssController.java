package com.snowsec0.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class DomxssController {
	
	@RequestMapping("/domxss")
	public String greeting(
			HttpServletRequest request,
			@RequestParam(name = "name", required = false, defaultValue = "world") String name,
			@RequestParam(name = "domxss1", required = false, defaultValue = "") String domxss1,
			@RequestParam(name = "domxss2", required = false, defaultValue = "") String domxss2,
			@RequestParam(name = "domxss3", required = false, defaultValue = "") String domxss3,
			@RequestParam(name = "domxss4", required = false, defaultValue = "") String domxss4,
			@RequestParam(name = "redirect", required = false, defaultValue = "") String redirect,
			Model model) {
		
		String urls = request.getRequestURL().toString();
		
//		try {
//			redirect = URLDecoder.decode(redirect, "utf-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			redirect = "";
//			e.printStackTrace();
//		}
		
		if(redirect.indexOf(":") != -1)
		{
			
		}else
		{
			redirect = urls.substring(0,urls.lastIndexOf("/")) + "/" +redirect;
		}
		
		
        model.addAttribute("xname", name);
        model.addAttribute("domxss1", domxss1);
        model.addAttribute("domxss2", domxss2);
        model.addAttribute("domxss3", domxss3);
        model.addAttribute("domxss4", domxss4);
        model.addAttribute("redirect", redirect);
        
        
        System.out.println(domxss1);
        return "index";
    }
	
	@RequestMapping("/adduser")
	public String submit(
			@RequestParam(name = "username", required = false, defaultValue = "admin") String username,
			@RequestParam(name = "password", required = false, defaultValue = "password") String password,
			Model model
			)
	{
		model.addAttribute("username",username);
		model.addAttribute("password",password);
		return "success";
	}
	
}
