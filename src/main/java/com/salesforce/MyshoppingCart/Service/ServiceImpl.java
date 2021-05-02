package com.salesforce.MyshoppingCart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.salesforce.MyshoppingCart.Entity.Category;
import com.salesforce.MyshoppingCart.Entity.Product;
import com.salesforce.MyshoppingCart.Repository.CategoryRepository;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

	@Autowired
	private CategoryRepository catRepo;
	
	@Override
	public List<Category> getCategoryList() {
	
		List<Category> list = null;
		try {
			list = catRepo.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void save(Category category) {
		
		catRepo.save(category);


		
	}

	@Override
	public void saveproduct(Product product) {
		// TODO Auto-generated method stub
		
	}

}
