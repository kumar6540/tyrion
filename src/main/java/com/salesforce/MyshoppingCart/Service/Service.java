package com.salesforce.MyshoppingCart.Service;

import java.util.List;

import com.salesforce.MyshoppingCart.Entity.Category;
import com.salesforce.MyshoppingCart.Entity.Product;

public interface Service {
	
	public List<Category> getCategoryList();

	public void save(Category category);

	public void saveproduct(Product product);
	
	

}
