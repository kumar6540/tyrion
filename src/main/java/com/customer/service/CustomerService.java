package com.customer.service;

import java.util.List;

import com.customer.Data.Customer;

public interface CustomerService {
	
	public  List<Customer> getCustomers(int theSortField);

	public void save(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomers(String theSearchName);

}
