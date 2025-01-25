package com.cattle.management.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cattle.management.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}