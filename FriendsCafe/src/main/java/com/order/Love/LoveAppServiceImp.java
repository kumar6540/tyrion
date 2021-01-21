package com.order.Love;

import org.springframework.stereotype.Service;

@Service
public class LoveAppServiceImp implements LoveAppService {

	
	public String getloveresult(int res) {
		
		if (res == 0) {
			return Lcappresult.F_result;
		} else if (res == 1) {
			return Lcappresult.L_result;
		} else if (res == 2) {
			return Lcappresult.A_result;
		} else if (res == 3) {
			return 	Lcappresult.M_result;
		} else if (res == 4) {
			return Lcappresult.E_result;
		} else if (res == 5) {
			return Lcappresult.S_result;
		} else 
		
		return null;
		}
	
	
	public String calculateLove(String username, String crushname) {
	
		int nameslength = (username+crushname).toCharArray().length;
		int flength = ("flames").toCharArray().length;
		
		int calres = nameslength%flength;
		
		
		String result = getloveresult(calres);
		return result;
		
	}

}
