package com.htc.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.htc.demo.entity.Address;
import com.htc.demo.entity.Employee;

@Configuration
public class BeanConfig {
	
	@Bean(name="address1")
	@Scope(scopeName = "prototype")
	public Address getAddress() {
		Address address = new Address();
		address.setCity("Bangalore");
		address.setPincode("KA-322323");
		return address;
	}
	
	@Bean(name="employee1")
	public Employee getEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeId("E101");
		employee.setEmployeeName("Natarajan");
		employee.setEmail("nallas@gmail.com");
		employee.setAddress(getAddress());
		return employee;
	}

}
