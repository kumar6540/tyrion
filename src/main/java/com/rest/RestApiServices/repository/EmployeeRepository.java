package com.rest.RestApiServices.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.RestApiServices.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	
	
	List<Employee> findByFirstName(String firstName);
	List<Employee> findByLastName(String lasstName);
	Employee findAllById(Integer id);

	
	
	
}
