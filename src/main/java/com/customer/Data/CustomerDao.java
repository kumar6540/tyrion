package com.customer.Data;

import java.util.List;

public interface CustomerDao {
	
	public List<Customer> getCustomers(int theSort);

	

	public void save(Customer customer);



	public Customer getCustomer(int id);



	public void deleteCustomer(int id);



	public List<Customer> searchCustomers(String theSearchName);
	

}
