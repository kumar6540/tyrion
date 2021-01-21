package com.order.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.order.Data.Phone;

public class Phoneformatter implements  Formatter<Phone>{

	@Override
	public String print(Phone object, Locale locale) {

		System.out.println("Inside formatter print method");
		return object.getCountrycode()+"-"+object.getPhonenumber();
	}

	@Override
	public Phone parse(String phonenumber, Locale locale) throws ParseException {
		System.out.println("Inside formatter");
		

		Phone phone = new Phone();
		String[] ph=phonenumber.split("-"); 
		
		int index = phonenumber.indexOf("-"); 
				if(index==-1 || phonenumber.startsWith("-")) {
					
			phone.setCountrycode("91");
			if(phonenumber.startsWith("-")) {
			phone.setPhonenumber(ph[0]);
			}else {phone.setPhonenumber(ph[1]);
			}
					
		}else {
				
		phone.setCountrycode(ph[0]);
		phone.setPhonenumber(ph[1]);
				}
		
		return phone;
	}
}
