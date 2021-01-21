package com.order.Data;

public class Phone {
	
	private String countrycode="91";
	private String phonenumber="22334455";
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	@Override
	public String toString() {
		return countrycode + "-" + phonenumber ;
	}

	
	
}
