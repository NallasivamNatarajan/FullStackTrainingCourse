package com.htc.event.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.event.management.entity.Status;


@Repository("statusRepository")
public interface StatusRepository extends CrudRepository<Status, Integer>{
}
