package com.salesforce.MyshoppingCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesforce.MyshoppingCart.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
