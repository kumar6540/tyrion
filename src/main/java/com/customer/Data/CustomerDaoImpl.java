package com.customer.Data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.customer.utill.SortUtils;

@Repository
public class CustomerDaoImpl implements CustomerDao
{

	@Autowired
	private SessionFactory sessionfactory;
	
	public List<Customer> getCustomers(int theSortField) {
	
		Session currentsession = sessionfactory.getCurrentSession();
		
		// determine sort field
				String theFieldName = null;
				
				switch (theSortField) {
					case SortUtils.first_name: 
						theFieldName = "firstname";
						break;
					case SortUtils.last_name:
						theFieldName = "lastname";
						break;
						
						
					case SortUtils.email:
						theFieldName = "email";
						break;
					default:
						// if nothing matches the default to sort by lastName
						theFieldName = "lastname";
				}
		
				
		Query<Customer> theQuery = currentsession.createQuery("from Customer order by "+theFieldName, Customer.class);
		
		
		
		List<Customer> list = theQuery.getResultList();
	
		return list;
	}

	public void save(Customer customer) {
		
		Session currentsession = sessionfactory.getCurrentSession();
		currentsession.saveOrUpdate(customer);
	}

	
	public Customer getCustomer(int id) {
		Session currentsession = sessionfactory.getCurrentSession();
		Customer customer=currentsession.get(Customer.class,id);
		return customer;
	}

	public void deleteCustomer(int id) {

		Session currentsession = sessionfactory.getCurrentSession();
		Query<?> theQuery = currentsession.createQuery("delete from Customer where id=:customer_id");
		theQuery.setParameter("customer_id", id);
		theQuery.executeUpdate();

		
	}

	public List<Customer> searchCustomers(String theSearchName) {
		
		   // get the current hibernate session
        Session currentSession = sessionfactory.getCurrentSession();
        Query<Customer> theQuery = null;
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Customer where lower(firstname) like :theName or lower(lastname) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Customer", Customer.class);            
        }
        
        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();
		
		
		return customers;
	}

}
