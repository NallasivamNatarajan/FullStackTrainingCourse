package com.htc.spring.entity.relation.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.htc.spring.entity.relation.entity.CattleFeed;

@Repository("cattleFeedRepository")
public interface CattleFeedRepository extends CrudRepository<CattleFeed, Integer> {
}
