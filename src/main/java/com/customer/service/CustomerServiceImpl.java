package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.customer.Data.Customer;
import com.customer.Data.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerdao;
	
	@Transactional
	public List<Customer> getCustomers(int theSort) {
		
		
		return customerdao.getCustomers(theSort);
	}

	@Transactional
	public void save(Customer customer) {
		customerdao.save(customer);
		
		
		
	}

	@Transactional
	public Customer getCustomer(int id) {
		
		return customerdao.getCustomer(id);
	}

	@Transactional
	public void deleteCustomer(int id) {

		customerdao.deleteCustomer(id);
	}

	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		
		return customerdao.searchCustomers(theSearchName);
	}

	

}
