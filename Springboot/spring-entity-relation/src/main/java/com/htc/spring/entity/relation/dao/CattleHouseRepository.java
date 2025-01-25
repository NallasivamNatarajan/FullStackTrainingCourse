package com.htc.spring.entity.relation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.spring.entity.relation.entity.CattleHouse;

@Repository("cattleHouseRepository")
public interface CattleHouseRepository extends CrudRepository<CattleHouse, Integer>{
}
