package com.material.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.material.management.entity.LineNumbers;

@Repository
public interface LineNumbersRepository extends JpaRepository<LineNumbers, Integer>{

}
