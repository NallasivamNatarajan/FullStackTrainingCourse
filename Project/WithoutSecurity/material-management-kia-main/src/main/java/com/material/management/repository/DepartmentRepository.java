package com.material.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.material.management.entity.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long>{

}
