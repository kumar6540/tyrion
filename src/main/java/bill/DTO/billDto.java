package bill.DTO;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class billDto {
	
	private Creditcard cardnum;
	private BigDecimal amount;
	
	private Date date;
	private Currency currency;
	
	
	public Creditcard getCardnum() {
		return cardnum;
	}
	public void setCardnum(Creditcard cardnum) {
		this.cardnum = cardnum;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	
	
	
}
