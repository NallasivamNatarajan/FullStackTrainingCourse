package com.htc.spring.entity.relation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.spring.entity.relation.entity.Cattle;

@Repository("cattleRepository")
public interface CattleRepository extends CrudRepository<Cattle, Integer> {
}
