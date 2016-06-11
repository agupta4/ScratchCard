package org.scratchcard.Model;

public class User {
	public String name;
	public String age;
	public String country;
	public Long zip;
	
	public User(String name, String age, String password) {
		super();
		this.name = name;
		this.age = age;
		this.country = password;
	}
	public User(){
		
	}
	
	
	
	public Long getZip() {
		return zip;
	}
	public void setZip(Long zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}
