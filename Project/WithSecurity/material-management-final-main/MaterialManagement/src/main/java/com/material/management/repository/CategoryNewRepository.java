package com.material.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.material.management.entity.Category;
@Repository
public interface CategoryNewRepository extends JpaRepository<Category, Long>  {

}
