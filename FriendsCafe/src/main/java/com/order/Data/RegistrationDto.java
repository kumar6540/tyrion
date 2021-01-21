package com.order.Data;

import org.springframework.stereotype.Component;

import com.order.validator.Age;

@Component
public class RegistrationDto {

	private String firstName;
	private String lastName;
	private String gender;
	
	@Age(lower = 20,upper = 50)
	private Integer age;
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	private String uname;
	private String password;
	
	
	
	private CommunicationDTO communicationdto;

	public CommunicationDTO getCommunicationdto() {
		return communicationdto;
	}
	public void setCommunicationdto(CommunicationDTO communicationdto) {
		this.communicationdto = communicationdto;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "RegistrationDto [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", age="
				+ age + ", uname=" + uname + ", password=" + password + ", communicationdto=" + communicationdto + "]";
	}
	







}
