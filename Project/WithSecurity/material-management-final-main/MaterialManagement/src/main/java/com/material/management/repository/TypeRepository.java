package com.material.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.material.management.entity.Type;
@Repository
public interface TypeRepository extends JpaRepository<Type, Long>  {

}
