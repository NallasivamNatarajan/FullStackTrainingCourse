package com.htc.spring.entity.relation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.spring.entity.relation.entity.Curative;

@Repository("curativeRepository")
public interface CurativeRepository extends CrudRepository<Curative, Integer>{
}
