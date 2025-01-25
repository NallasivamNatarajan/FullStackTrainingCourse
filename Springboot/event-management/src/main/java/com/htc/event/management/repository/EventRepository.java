package com.htc.event.management.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.event.management.entity.Event;

@Repository("eventRepository")
public interface EventRepository extends CrudRepository<Event, Integer>{
	
	@Query(value = "select evn.event_name, Count(reg.participant_id) as 'count_participant_event' "
			+ "from tb_event evn"
			+ "Join tb_registration reg on evn.event_id=reg.event_id"
			+ "group by evn.event_id", nativeQuery = true)
	 Set<Event> getEventsReport();
	
}
