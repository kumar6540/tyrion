package com.rest.RestApiServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"com.rest.RestApiServices.service","com.rest.RestApiServices.controller","com.rest.RestApiServices.entity"})
//@EntityScan("com.rest.RestApiServices.entity")
@EnableJpaRepositories
public class RestApiServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiServicesApplication.class, args);
	}

}
