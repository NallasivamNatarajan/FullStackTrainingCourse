package com.htc.spring.entity.relation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.spring.entity.relation.entity.Feeds;

@Repository("feedsRepository")
public interface FeedsRepository extends CrudRepository<Feeds, Integer>{
}
