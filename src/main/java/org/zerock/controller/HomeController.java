package org.zerock.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.dto.SampleDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// method방식이 get일때
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		return "home";
//	}
	
	
	@GetMapping(value = "/")
	public String home(SampleDTO dto,Model model) {
		System.out.println(dto);
		model.addAttribute("abcd", dto);
		return "home";
	}
	
	// method방식이 post일때
//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	public String home(Locale locale, Model model) {
//		return "home";
//	}
	
//	@PostMapping(value = "/")
//	public String home(Locale locale, Model model) {
//		return "home";
//	}
	
	
//	@RequestMapping(value = "/index", method = RequestMethod.GET)
//	public String abc() {
//		return "index";
//	}
	
	
	 @RequestMapping(value = "/index", method = RequestMethod.GET)
	 public void abc() { 
		  
	 }
	 	
}











