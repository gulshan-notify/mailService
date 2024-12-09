package com.example.mailService.mailController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DespatcherController {

	@GetMapping(value = "login")
	public String home() {
		return "home";
	}
	
	
}
