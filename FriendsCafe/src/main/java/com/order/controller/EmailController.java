package com.order.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.order.Data.EmailDto;
import com.order.EmailService.LoveEmailService;
import com.order.Love.LoveAppDto;

@Controller
@SessionAttributes({"Einfo","uinfo"})
public class EmailController {
	
	@Autowired
	private LoveEmailService LE;

	@RequestMapping("/SendEmail")
	public String Initial(Model model ) {
		
		System.out.println("Send init");
		model.addAttribute("Einfo", new EmailDto());
	return "SendEmail";
	}
	
	@RequestMapping("/emailconfirm")
	public String Binder(@ModelAttribute("Einfo") EmailDto emaildto,@SessionAttribute("uinfo") LoveAppDto love, HttpServletRequest request) {
		
		System.out.println(emaildto.getEmail());
		System.out.println(love.getyName());
		

		
		LE.SendEmail(love.getyName(), love.getCrushName(), emaildto.getEmail(), love.getLoveResult());
		
	
	  HttpSession session = request.getSession();
	  
	  session.setAttribute("yName", love.getyName());
	 
		
		
		return "emailconfirm";
	}
	
	
}
