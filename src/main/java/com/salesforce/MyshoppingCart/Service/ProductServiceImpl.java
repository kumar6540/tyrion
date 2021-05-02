package com.salesforce.MyshoppingCart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesforce.MyshoppingCart.Entity.Product;
import com.salesforce.MyshoppingCart.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;
	
	@Override
	public void saveproduct(Product product) {
		
		repo.save(product);
		
	}

	@Override
	public List<Product> getProductList() {
		
		List<Product> list = repo.findAll();
		return list;
	}

	@Override
	public Product getProductById(Integer id) {
		
		Optional<Product> product =repo.findById(id);
		return product.get();
	}

	@Override
	public void deleteById(Integer id) {
	
		repo.deleteById(id);
		
	}

	
}
