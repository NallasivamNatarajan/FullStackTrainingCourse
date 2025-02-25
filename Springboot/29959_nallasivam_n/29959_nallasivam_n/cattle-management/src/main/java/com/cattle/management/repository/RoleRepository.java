package com.cattle.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cattle.management.entity.Role;

@Repository("roleRepository")
public interface RoleRepository extends CrudRepository<Role, Integer>{
}
