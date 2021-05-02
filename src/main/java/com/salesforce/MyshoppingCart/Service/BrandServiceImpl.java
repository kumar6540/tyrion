package com.salesforce.MyshoppingCart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesforce.MyshoppingCart.Entity.Brand;
import com.salesforce.MyshoppingCart.Repository.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepo;
	
	
	@Override
	public void save(Brand brand) {
	
		brandRepo.save(brand);
		
	}


	@Override
	public List<Brand> getBrandList() {
	
		List<Brand> list = brandRepo.findAll();
		return list;
	}


	@Override
	public Brand getBrandById(Integer id) {
		
		Optional<Brand> brand = brandRepo.findById(id);
		return brand.get();
	}


	@Override
	public void deleteById(Integer id) {
		
		brandRepo.deleteById(id);
	}

	
}
