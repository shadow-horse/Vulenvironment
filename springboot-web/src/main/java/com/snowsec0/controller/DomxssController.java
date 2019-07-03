package com.snowsec0.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class DomxssController {
	
	@RequestMapping("/domxss")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "world") String name,Model model) {
        model.addAttribute("xname", name);
        return "index";
    }

}
