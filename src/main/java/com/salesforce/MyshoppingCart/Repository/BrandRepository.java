package com.salesforce.MyshoppingCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesforce.MyshoppingCart.Entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
