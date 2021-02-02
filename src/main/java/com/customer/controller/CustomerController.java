package com.customer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.customer.Data.Customer;
import com.customer.service.CustomerService;
import com.customer.utill.SortUtils;

@Controller
public class CustomerController {

	
	@Autowired
	private CustomerService customerservice;
	
	@RequestMapping("/")
	public String indexpage() {
		return "index";
	}
	
	@RequestMapping("/list-customers")
	public String listCustormer(Model model,@RequestParam(required=false) String sort) {
		
		//Getting customer from the dao
		
		List<Customer> thecustomers = null;
		
		if(sort!=null) {
			
			int theSortField = Integer.parseInt(sort);
			thecustomers=customerservice.getCustomers(theSortField);
			
		}else {
			
			thecustomers=customerservice.getCustomers(SortUtils.last_name);
			
		}
		
		
		System.out.println(thecustomers);		
		model.addAttribute("customers",thecustomers);
			
		return "list-customers";
		
	}
	
	@GetMapping("/ShowFormForAdd")
	public String ShowAddFor(Model model) {
	
		
		model.addAttribute("thecustomer", new Customer() );
		
		return "AddCustomer";
		
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("thecustomer") Customer customer) {
		
		//Saving customer
		customerservice.save(customer);
		
		
		
	return "redirect:list-customers";
	
	}
	
	@GetMapping("/showUpdateForm")
	public String updateCustomer(@RequestParam("customerId") int Id,Model themodel) {
		
		Customer customer = customerservice.getCustomer(Id);
		
		themodel.addAttribute("thecustomer", customer);
		
		return "AddCustomer";
			
	}

	@GetMapping("/Delete")
	public String deleteCustomer(@RequestParam("customerId") int Id,Model themodel) {
		
		customerservice.deleteCustomer(Id);
		
		
		return "redirect:list-customers";}
			
	
	
    @GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search customers from the service
        List<Customer> theCustomers = customerservice.searchCustomers(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";        
    }

}
