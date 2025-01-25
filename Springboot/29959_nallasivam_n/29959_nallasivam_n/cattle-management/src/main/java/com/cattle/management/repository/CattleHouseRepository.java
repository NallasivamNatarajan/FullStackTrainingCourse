package com.cattle.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cattle.management.entity.CattleHouse;

@Repository("cattleHouseRepository")
public interface CattleHouseRepository extends CrudRepository<CattleHouse, Integer>{
}
