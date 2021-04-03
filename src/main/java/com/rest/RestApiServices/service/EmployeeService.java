package com.rest.RestApiServices.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.rest.RestApiServices.entity.Employee;

@Service
public interface EmployeeService {

	List<Employee> getEmployees();
	
	Employee getEmployeeById(Integer id);
	
	List<Employee> getByFirstName(String firstName);
	
	List<Employee> getByLastName(String lastName);
	
	Employee saveEmployee(Employee employee);
	
	 void deletebyId(int EmpId);
	 
	 
}
