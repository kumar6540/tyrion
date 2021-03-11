package com.rest.RestApiServices.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.RestApiServices.entity.Address;
import com.rest.RestApiServices.entity.Employee;
import com.rest.RestApiServices.entity.Knownlanguages;
import com.rest.RestApiServices.repository.AddressRepository;
import com.rest.RestApiServices.repository.EmployeeRepository;
import com.rest.RestApiServices.repository.KnownlanguagesRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	AddressRepository  addressRepository;
	
	@Autowired
	KnownlanguagesRepository knownlanguagesRepository;
	
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
		
		addressRepository.save(employee.getAddress());
		
		List<Knownlanguages> languages = new ArrayList<Knownlanguages>();
		
		for(Knownlanguages lang : languages) {
			
			languages.add(lang);
		}
		
		knownlanguagesRepository.saveAll(languages);
	
	}


	@Transactional
	public void deletebyId(int EmpId) {
	
		employeeRepository.deleteById(EmpId);
		
		
	}



}
