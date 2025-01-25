package com.htc.spring.entity.relation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.spring.entity.relation.entity.CattleTransfer;

@Repository("cattleTransferRepository")
public interface CattleTransferRepository extends CrudRepository<CattleTransfer, Integer>{
}
