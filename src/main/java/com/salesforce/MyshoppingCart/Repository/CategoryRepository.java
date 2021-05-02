package com.salesforce.MyshoppingCart.Repository;

import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesforce.MyshoppingCart.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	
}
