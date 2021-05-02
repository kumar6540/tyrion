package com.salesforce.MyshoppingCart.Service;

import java.util.List;

import com.salesforce.MyshoppingCart.Entity.Brand;

public interface BrandService {

	 void save(Brand brand) ;

	List<Brand> getBrandList();

	Brand getBrandById(Integer id);

	void deleteById(Integer id);

}
