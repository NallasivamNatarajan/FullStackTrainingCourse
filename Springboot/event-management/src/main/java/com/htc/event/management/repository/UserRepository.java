package com.htc.event.management.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.htc.event.management.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}