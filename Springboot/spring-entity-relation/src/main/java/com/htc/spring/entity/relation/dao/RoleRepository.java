package com.htc.spring.entity.relation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.spring.entity.relation.entity.Role;

@Repository("roleRepository")
public interface RoleRepository extends CrudRepository<Role, Integer>{
}
