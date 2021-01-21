package com.order.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.order.Data.CommunicationDTO;
import com.order.Data.Fooditem;
import com.order.Data.Phone;
import com.order.Data.RegistrationDto;
import com.order.Data.loginDTO;
import com.order.store.Loginstore;
import com.order.validator.NamespringValidator;

import com.order.Love.LoveAppDto;
import com.order.Love.LoveAppServiceImp;

@Controller
@SessionAttributes( {"log","info","uinfo","fitem"})
public class OrderController {
	@Autowired
    private LoveAppServiceImp loveAppServiceImp;
	
	@RequestMapping("/index")
	public String indexpage() {

		System.out.println("Index page intializer");
		return "index";
	}

	@RequestMapping("/order")
	public String orderpage(Model model) {

		model.addAttribute("fitem",new Fooditem());
		System.out.println("this is order page intializer");

		return "order";
	}

	@RequestMapping("/login")
	public String loginpage(Model model) {

		model.addAttribute("log", new loginDTO());
		System.out.println("this is login page intializer");

		return "login";
	}

	@RequestMapping("/Welcompage")
	public String Welcomepage() {

		System.out.println("this is Welcome page intializer");

		return "Welcomepage";
	}

	@RequestMapping(value = "/procced", method = RequestMethod.POST)
	public String loginprocess(@ModelAttribute("log") @Valid loginDTO logins, BindingResult br, Loginstore store,
			HttpSession session, HttpServletResponse response) {

		String UserName = logins.getUname();
		String Pass = logins.getPass();

		try {
			
			
			if (store.check(UserName, Pass)) {

				session.setAttribute("Username", UserName);
			} else {
				System.out.println("Wrong Credentials");
				if (br.hasErrors()) {
					System.out.println("Form has errors");

					PrintWriter out = response.getWriter();
					out.print("Wrong Credentials");

					return "login";
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return "Welcomepage";
	}


	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpSession session) {

		session.removeAttribute("Username");

		System.out.println("this is logout intializer");

		return "Welcomepage";
	}

	@RequestMapping("/userregistration")
	public String registrationpage(Model model, RegistrationDto udto)

	{

		
		Phone ph = new Phone();
		ph.setCountrycode("91");
		ph.setPhonenumber("22334455");
		CommunicationDTO cdto = new CommunicationDTO();
		cdto.setPhone(ph);
		udto.setCommunicationdto(cdto);
		model.addAttribute("info", udto);

		return "userregistration";
	}

	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public String proccess(@ModelAttribute("fitem") Fooditem f,BindingResult br) {

		//String item = (String) request.getParameter("Orderitem");
		System.out.println(f.getItem());

		//m.addAttribute("itemname", item);

		return "process";

	}

	@RequestMapping(value = "/Registration", method = RequestMethod.POST)
	public String registration(@Valid @ModelAttribute("info") RegistrationDto dto, BindingResult br, Model m,
			Loginstore store) {

		System.out.println("Registration Controller");
		if ((store.StoreCredentials(dto.getUname(), dto.getPassword())) == 1)

		{

			if (br.hasErrors()) {

				System.out.println("Page has errors");

				List<ObjectError> allErrors = br.getAllErrors();
				for (ObjectError err : allErrors) {

					System.out.println(err);
				}

				return "userregistration";
			}
			return "userinfo";

		}

		else
			return "userregistration";

	}

	

	@RequestMapping("/Loveapp")
	public String Initial(Model model) {
		
		System.out.println("App init");
		
		 LoveAppDto love = new LoveAppDto();
		  
		  model.addAttribute("uinfo", love);
		 
	return "Loveapp";
	}
	
	@RequestMapping("/appresult")
	public String Binder(@Valid @ModelAttribute("uinfo") LoveAppDto love, BindingResult bresult) {
		
		
		String lovereulst=loveAppServiceImp.calculateLove(love.getyName(), love.getCrushName());
		love.setLoveResult(lovereulst);
		if(bresult.hasErrors()) {
			List<ObjectError> err = bresult.getAllErrors();
			for(ObjectError temp: err) {
				System.out.println(temp);
			}
		}
		//model.addAttribute("loveappresult", lovereulst);
		
		
		return "appresult";
	}
	
	
	@InitBinder("info")
	public void initBinder(WebDataBinder binder) {
		System.out.println("Inside initbinder");

		/*
		 * StringTrimmerEditor Strim = new StringTrimmerEditor(false);
		 * 
		 * binder.registerCustomEditor(String.class, "firstName",Strim);
		 */

		/*
		 * NamepropertyEditor firstnameEditor = new NamepropertyEditor();
		 * binder.registerCustomEditor(String.class, "firstName", firstnameEditor);
		 * 
		 * NamepropertyEditor lastnameEditor = new NamepropertyEditor();
		 * binder.registerCustomEditor(String.class, "lastName", lastnameEditor);
		 */
		
		
		
		 binder.addValidators(new NamespringValidator());
		
		 

	}

}
