package formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import bill.DTO.Creditcard;

public class cardformetter implements Formatter<Creditcard>{


	public String print(Creditcard cardnum, Locale locale) {
		
		System.out.println("Card Formatter print");


		return cardnum.getFirst()+"-"+cardnum.getSecond()+"-"+cardnum.getThird()+"-"+cardnum.getFourth();
	}


	public Creditcard parse(String cardnumber, Locale locale) throws ParseException {

		String[] cardArray = cardnumber.split("-");

		Creditcard cr = new Creditcard();

		cr.setFirst(Integer.parseInt(cardArray[0]));
		cr.setSecond(Integer.parseInt(cardArray[1]));
		cr.setThird(Integer.parseInt(cardArray[2]));
		cr.setFourth(Integer.parseInt(cardArray[3]));

		return cr;
	}


}
