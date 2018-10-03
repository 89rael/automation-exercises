package com.automation.models;

public class User {
	
	private String name;
	
	private String lastName;
	
	private String password;
	
	private String address;
	
	private String city;
	
	private String zipcode;
	
	private String phoneMobile;


	public User(String name, 
			String lastName,
			String password,
			String address, 
			String city, 
			String zipcode,
			String phoneMobile) 
	{
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
		this.phoneMobile = phoneMobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhoneMobile() {
		return phoneMobile;
	}

	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}
	
	

}
