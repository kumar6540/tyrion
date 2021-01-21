package com.order.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
public class loginDTO {
	
	@NotBlank(message = " * Username shouldn't be blank")
	@Min(message = "min char 3 are needed", value = 3)
	private String uname;
	
	private String pass;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "loginDTO [uname=" + uname + ", pass=" + pass + "]";
	}
	
	
	
	

}
