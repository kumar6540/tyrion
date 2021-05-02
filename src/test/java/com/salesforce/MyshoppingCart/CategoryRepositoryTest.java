package com.salesforce.MyshoppingCart;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.salesforce.MyshoppingCart.Entity.Category;
import com.salesforce.MyshoppingCart.Repository.CategoryRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository repo;
	
	
	@Test
	public void testCreateCatory() {
		
		Category saveCategory = repo.save(new Category("Electronics"));
		
		assertThat(saveCategory.getId()).isGreaterThan(0);
		
	}
}
