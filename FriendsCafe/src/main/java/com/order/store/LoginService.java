package com.order.store;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.order.config.ServletConfig;

public class LoginService {
	
	public boolean check(String uname , String pass) throws ClassNotFoundException {
		
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ServletConfig.class);

        Loginstore lg = (Loginstore) context.getBean("logservice");
		
        return lg.check(uname, pass);
		
		
		
		
		
		
	}

}
