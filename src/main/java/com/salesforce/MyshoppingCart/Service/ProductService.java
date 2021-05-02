package com.salesforce.MyshoppingCart.Service;

import java.util.List;

import com.salesforce.MyshoppingCart.Entity.Product;

public interface ProductService {

	void saveproduct(Product product);

	List<Product> getProductList();

	Product getProductById(Integer id);

	void deleteById(Integer id);

}
