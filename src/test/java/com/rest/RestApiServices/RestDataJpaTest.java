package com.rest.RestApiServices;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.util.TestUtils;
import com.rest.RestApiServices.controller.EmployeeController;
import com.rest.RestApiServices.entity.Address;
import com.rest.RestApiServices.entity.Employee;
import com.rest.RestApiServices.entity.Knownlanguages;
import com.rest.RestApiServices.service.EmployeeService;


@AutoConfigureMockMvc
@SpringBootTest

@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class RestDataJpaTest {
	
	@Autowired
	private EmployeeController controller;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	EmployeeService employeeService;
	
	@Test
	public void addEmployeeTest() throws Exception {
		Knownlanguages kl = new Knownlanguages(1, "Rubi");
		List<Knownlanguages> lang= new ArrayList<Knownlanguages>(); 
		lang.add(kl);
		
		Address address = new Address(1, "Eluru", "Andhra", 534004);
		Employee emp = new Employee(1, "Ironman", "Stark", "stark@gmail.com", address, lang);
	    
		/*
		 * String jsonRequest = objectMapper.writer().writeValueAsString(emp);
		 * System.out.println(jsonRequest); mockMvc.perform(post("/api/saveEmployee")
		 * .contentType(MediaType.APPLICATION_JSON) .content(jsonRequest)
		 * .accept(MediaType.APPLICATION_JSON)) .andExpect(status().isOk())
		 * 
		 * ;
		 */
		
		
		
	}
	
	
	@Test
	public void testGetEmployeeList() throws Exception {
	
	
			/*
			 * MvcResult result = mockMvc.perform(get(url)).andReturn();
			 * 
			 * String response =result.getResponse().getContentAsString();
			 * System.out.println(response);
			 */	
	    String url = "/api/Emplist";
		 mockMvc.perform(get(url)).andDo(print());      
	
	}
	
	
	

}
