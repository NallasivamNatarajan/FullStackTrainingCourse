package com.htc.spring.entity.relation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.spring.entity.relation.entity.Employees;

@Repository("EmployeesRepository")
public interface EmployeesRepository extends CrudRepository<Employees, Integer>{
}
