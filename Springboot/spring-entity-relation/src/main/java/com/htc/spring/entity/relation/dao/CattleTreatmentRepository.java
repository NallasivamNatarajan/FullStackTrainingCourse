package com.htc.spring.entity.relation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.spring.entity.relation.entity.CattleTreatment;

@Repository("cattleTreatmentRepository")
public interface CattleTreatmentRepository extends CrudRepository<CattleTreatment, Integer>{
}
