package com.rest.RestApiServices.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.RestApiServices.entity.Employee;
import com.rest.RestApiServices.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Transactional
	public List<Employee> getEmployees() {
	
		
		return employeeRepository.findAll();
	}


	@Transactional
	public List<Employee> getByFirstName(String firstName) {
		
		return employeeRepository.findByFirstName(firstName);
	}


	@Transactional
	public List<Employee> getByLastName(String lastName) {
			return employeeRepository.findByLastName(lastName);
	}


	@Transactional
	public Employee getEmployeeById(Integer id) {

		return employeeRepository.findAllById(id);
	}


	@Transactional
	public void saveEmployee(Employee employee) {
		
		Employee emp = employeeRepository.save(employee);
	
	}


	@Transactional
	public void deletebyId(int EmpId) {
	
		employeeRepository.deleteById(EmpId);
		
		
	}



}
