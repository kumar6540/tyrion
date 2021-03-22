package com.reactivepractice.fluxmonoEndpoints.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Employee {
	@Id
	final private String id;
	
	final private String name;

}
