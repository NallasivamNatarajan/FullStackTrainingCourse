package com.cattle.management.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.cattle.management.dto.EmployeesDTO;
import com.cattle.management.entity.Employees;

@Component
public class EmployeesConverter {

	public Employees dtoToEntity(EmployeesDTO employeesDto) {
		Employees employees = new Employees();
		BeanUtils.copyProperties(employeesDto, employees);
		return employees;
	}

	public EmployeesDTO entityToDto(Employees employees) {
		EmployeesDTO employeesDto = new EmployeesDTO();
		BeanUtils.copyProperties(employees, employeesDto);
		return employeesDto;
	}
}
