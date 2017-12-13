package com.train.webstore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/welcome")
	public String welcome(Model model){
		//model.addAttribute("welcome", "-----welcome to webstore!!!!");
		return "welcome";
	}
	
	@RequestMapping("/")
	public String toWelcome(Model model){
		model.addAttribute("welcome", "-----welcome to webstore!!!!");
		return "forward:/welcome";
		
	}
	
	

}
