package com.cattle.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cattle.management.entity.Employees;

@Repository("EmployeesRepository")
public interface EmployeesRepository extends CrudRepository<Employees, Integer>{
}
