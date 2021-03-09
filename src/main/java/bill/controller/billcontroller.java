package bill.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import bill.DTO.Creditcard;
import bill.DTO.billDto;
import formatter.cardformetter;

@Controller
public class billcontroller {
	
	@RequestMapping("/paybill")
	public String initializer(@ModelAttribute("bill") billDto bill) {
		
		
		System.out.println("Initializer");
	
		Creditcard cardnum = new Creditcard();
		
		cardnum.setFirst(1111);
		cardnum.setSecond(2222);
		cardnum.setThird(3333);
		cardnum.setFourth(4444);
		
		bill.setCardnum(cardnum );
	
		return "paybill";
		
	}
	
	@RequestMapping("/result")
	public String databinder(@Valid @ModelAttribute("bill") billDto bill, BindingResult br) {
		
		System.out.println("Data Binder");

		if(br.hasErrors()) {
			
			return "paybill";
		}
		
		return "confirm";
		
		
		
	}
	
	@InitBinder
	public void initilaBinder(WebDataBinder wb) {
	
	wb.addCustomFormatter(new cardformetter());
	
	
	}
	
	

}
