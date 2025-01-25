package com.htc.spring.entity.relation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.spring.entity.relation.dao.EmployeesRepository;
import com.htc.spring.entity.relation.entity.Employees;

@Service("employeesService")
public class EmployeesService {
	@Autowired
	EmployeesRepository employeesRepository;

	public Employees addEmployees(Employees employees) {
		return employeesRepository.save(employees);
	}

	public void deleteEmployees(int employeeId) {
		employeesRepository.deleteById(employeeId);
	}

	public Employees getEmployeesById(int employeesId) {
		Optional<Employees> employees = employeesRepository.findById(employeesId);
		if (employees.isPresent())
			return employees.get();
		else
			return null;
	}

	public List<Employees> getAllEmployees() {
		return (List<Employees>) employeesRepository.findAll();
	}

	public int updateEmployees(Employees employees) {
		Employees employeesModel = employeesRepository.save(employees);
		return employeesModel.getEmployeeId();
	}
}
