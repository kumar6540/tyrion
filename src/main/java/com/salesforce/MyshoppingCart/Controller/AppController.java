package com.salesforce.MyshoppingCart.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@GetMapping("/")
	public String homepage() {
		
		return "index";
		}
	
	
	

}
