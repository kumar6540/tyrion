package com.order.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class LoveEmailService implements EMailService {


	@Autowired
	private JavaMailSenderImpl javamailsender;
	
	

	@Override
	public void SendEmail(String username, String crushname, String Email, String Result) {
        
		SimpleMailMessage newEmail = new SimpleMailMessage();
		
		newEmail.setTo(Email);
		newEmail.setSubject("Lova Calculator Application Result");
		newEmail.setText("Hi"+username+
				"your love app result with your crush"+crushname+"is"+Result);
			
		javamailsender.send(newEmail);
	}
	
	
	

}
