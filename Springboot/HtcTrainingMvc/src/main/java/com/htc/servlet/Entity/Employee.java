package com.htc.servlet.Entity;
public class Employee {
private int empId;
private String name,password,email,country;
public Employee(int empId, String name, String password, String email, String country) {
	super();
	this.empId = empId;
	this.name = name;
	this.password = password;
	this.email = email;
	this.country = country;
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}

}
