package com.cattle.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cattle.management.entity.Cattle;

@Repository("cattleRepository")
public interface CattleRepository extends CrudRepository<Cattle, Integer> {
}
