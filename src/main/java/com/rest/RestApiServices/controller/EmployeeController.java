package com.rest.RestApiServices.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.RestApiServices.entity.Employee;
import com.rest.RestApiServices.exception.EmployeeCustomException;
import com.rest.RestApiServices.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/Emplist")
	public List<Employee> getEmployees(){
		
		return employeeService.getEmployees();
		
	}
	
	@GetMapping("/employeeById/{id}")
	public Employee getEmployeeByid(@PathVariable Integer id) {
	
		
		return employeeService.getEmployeeById(id);}
	
	@GetMapping("/employeeByfirstName/{firstName}")
	public List<Employee> getEmployeeByfirstName(@PathVariable String firstName){
		
		return employeeService.getByFirstName(firstName);
		
	}
	
	
	@GetMapping("/employeeBylastName/{lastName}")
	public List<Employee> getEmployeeBylastName(@PathVariable String lastName){
		
		return employeeService.getByLastName(lastName);
		
	}
	
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		
		
		 employeeService.saveEmployee(employee);

		return employee;
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee UEmployee) {
	
		employeeService.saveEmployee(UEmployee);
	
	
		return UEmployee;
	
	}
	
	@DeleteMapping("/deleteEmployee/{EmpId}")
	public String deletEmployee(@PathVariable int EmpId) {
		Employee tempEmp = employeeService.getEmployeeById(EmpId);
		
		if(tempEmp==null) {
			throw new EmployeeCustomException("Employee id not found:"+ EmpId);
		}
		
		employeeService.deletebyId(EmpId);
		
		return "Employee is deleted with id:"+ EmpId;
	}
	
}
