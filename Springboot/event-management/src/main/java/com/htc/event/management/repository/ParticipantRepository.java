package com.htc.event.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.event.management.entity.Participant;

@Repository("participantRepository")
public interface ParticipantRepository extends CrudRepository<Participant, Integer>{
}
