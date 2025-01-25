package com.htc.spring.data.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.spring.data.jpa.entity.Cattle;

@Repository("cattleRepository")
public interface CattleRepository extends CrudRepository<Cattle, Integer> {
}
