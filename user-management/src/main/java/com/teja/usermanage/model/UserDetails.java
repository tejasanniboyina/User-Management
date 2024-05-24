package com.teja.usermanage.model;

public class UserDetails {
	int id;
	String name;
	String email;
	String country;
	
	
	public UserDetails(int id, String name, String email, String country) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
	}
	
	
	public UserDetails( String name, String email, String country) {
		super();
		this.name = name;
		this.email = email;
		this.country = country;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountry() {
		return country;
	}

}
