package com.htc.demo.entity;

public class Employee {
private String employeeId;
private String employeeName;
private String email;
private Address address;

public Employee(String employeeId, String employeeName, String email, Address address) {
	super();
	this.employeeId = employeeId;
	this.employeeName = employeeName;
	this.email = email;
	this.address = address;
}

public Employee() {
	super();
}

public String getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(String employeeId) {
	this.employeeId = employeeId;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}

@Override
public String toString() {
	return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email + ", address="
			+ address + "]";
}

}
