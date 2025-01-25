package com.cattle.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cattle.management.entity.Users;

@Repository("usersRepository")
public interface UsersRepository extends CrudRepository<Users, Integer>{
}
