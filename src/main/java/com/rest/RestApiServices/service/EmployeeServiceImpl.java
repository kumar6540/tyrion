package com.rest.RestApiServices.service;

import java.util.List;
import java.util.NoSuchElementException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.RestApiServices.entity.Employee;
import com.rest.RestApiServices.exception.EmployeeCustomException;
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
	public Employee saveEmployee(Employee employee) {
		
		Employee emp = employeeRepository.save(employee);
		/*
		 * addressRepository.save(employee.getAddress());
		 * 
		 * List<Knownlanguages> languages = new ArrayList<Knownlanguages>();
		 * 
		 * for(Knownlanguages lang : languages) {
		 * 
		 * languages.add(lang); }
		 * 
		 * knownlanguagesRepository.saveAll(languages);
	
		 */
		return emp;
		
	}


	@Transactional
	public void deletebyId(int EmpId) {
		
	
		try {
			Employee findById = employeeRepository.findById(EmpId).get();
		}catch (NoSuchElementException e) {
			throw new EmployeeCustomException("Employee with id: "+EmpId+"Not found in DB");
		
		} 		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
			employeeRepository.deleteById(EmpId);
		
		
		
	}




}
