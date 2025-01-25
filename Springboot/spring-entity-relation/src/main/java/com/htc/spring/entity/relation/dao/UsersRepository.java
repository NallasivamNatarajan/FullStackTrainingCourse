package com.htc.spring.entity.relation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.spring.entity.relation.entity.Users;

@Repository("usersRepository")
public interface UsersRepository extends CrudRepository<Users, Integer>{
}
