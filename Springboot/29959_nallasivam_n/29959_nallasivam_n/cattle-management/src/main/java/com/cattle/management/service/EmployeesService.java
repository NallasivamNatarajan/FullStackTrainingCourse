package com.cattle.management.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.cattle.management.converter.EmployeesConverter;
import com.cattle.management.dto.EmployeesDTO;
import com.cattle.management.entity.Employees;
import com.cattle.management.exception.TaskException;
import com.cattle.management.repository.EmployeesRepository;

@Service("employeesService")
public class EmployeesService {
	@Autowired
	EmployeesRepository employeeRepository;

	@Autowired
	EmployeesConverter employeeConverter;

	private static final Logger log = LoggerFactory.getLogger(RoleService.class);

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public EmployeesDTO addEmployees(EmployeesDTO employeeDto) throws TaskException {
		if (Objects.nonNull(employeeDto)) {
			Employees employee = employeeConverter.dtoToEntity(employeeDto);
			if (Objects.nonNull(employee))
				return employeeConverter.entityToDto(employeeRepository.save(employee));
			else
				throw new TaskException("Employees Data couldn't be inserted", HttpStatus.BAD_REQUEST);
		} else {
			throw new TaskException("Employees Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public boolean deleteEmployees(int employeeId) throws TaskException {
		Optional<Employees> employeeOptional = employeeRepository.findById(employeeId);
		if (employeeOptional.isPresent()) {
			employeeRepository.deleteById(employeeId);
			return true;
		} else {
			throw new TaskException("Employees Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public EmployeesDTO getEmployeesById(int employeeId) throws TaskException {
		Optional<Employees> employeeOptional = employeeRepository.findById(employeeId);
		if (employeeOptional.isPresent())
			return employeeConverter.entityToDto(employeeOptional.get());
		else {
			throw new TaskException("Employees Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public Set<EmployeesDTO> getAllEmployees() throws TaskException {
		List<Employees> employeeList = (List<Employees>) employeeRepository.findAll();
		if (!CollectionUtils.isEmpty(employeeList)) {
			return employeeList.stream().map(employee -> employeeConverter.entityToDto(employee)).collect(Collectors.toSet());
		} else {
			throw new TaskException("Employees Infirmation not Found", HttpStatus.NOT_FOUND);
		}
	}

	public EmployeesDTO updateEmployees(EmployeesDTO employeesDTO) throws TaskException {
		if (Objects.nonNull(employeesDTO)) {
			Optional<Employees> employeeOptional = employeeRepository.findById(employeesDTO.getEmployeeId());
			if (employeeOptional.isPresent())
				return employeeConverter.entityToDto(employeeRepository.save(employeeConverter.dtoToEntity(employeesDTO)));
			else {
				throw new TaskException("Employees Data not Updated", HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new TaskException("Employees Infirmation not Found", HttpStatus.NOT_FOUND);
		}
	}
}