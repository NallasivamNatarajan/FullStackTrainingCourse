package com.htc.event.management.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.htc.event.management.converter.EventConverter;
import com.htc.event.management.dto.EventDTO;
import com.htc.event.management.entity.Event;
import com.htc.event.management.exception.TaskException;
import com.htc.event.management.repository.EventRepository;

@Service("eventService")
public class EventService {
	
	@Autowired
	EventRepository eventRepository;

	@Autowired
	EventConverter eventConverter;
	
	private static final Logger log = LoggerFactory.getLogger(StatusService.class);

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public EventDTO addEvent(EventDTO eventDTO) throws TaskException {
		if (Objects.nonNull(eventDTO)) {
			Event event = eventConverter.dtoToEntity(eventDTO);
			if (Objects.nonNull(event)) {
				log.info("Event added successfully");
				return eventConverter.entityToDto(eventRepository.save(event));
			} else
				throw new TaskException("Event Info couldn't be inserted", HttpStatus.BAD_REQUEST);
		} else {
			throw new TaskException("Event Info not valid", HttpStatus.NOT_FOUND);
		}
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public EventDTO getEventById(int eventId) throws TaskException {
		Optional<Event> eventOptional = eventRepository.findById(eventId);
		if (eventOptional.isPresent()) {
			log.info("Event fetched successfully");
			return eventConverter.entityToDto(eventOptional.get());
		} else {
			throw new TaskException("Event Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public Set<EventDTO> getAllEvent() throws TaskException {
		List<Event> eventList = (List<Event>) eventRepository.findAll();
		if (!CollectionUtils.isEmpty(eventList)) {
			return eventList.stream().map(event -> eventConverter.entityToDto(event))
					.collect(Collectors.toSet());
		} else {
			throw new TaskException("Event Infirmation not Found", HttpStatus.NOT_FOUND);
		}
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public Set<EventDTO> getEventsReport() throws TaskException {
		Set<Event> eventSet = (Set<Event>) eventRepository.getEventsReport();
		if (!CollectionUtils.isEmpty(eventSet)) {
			return eventSet.stream().map(event -> eventConverter.entityToDto(event))
					.collect(Collectors.toSet());
		} else {
			throw new TaskException("Event Infirmation not Found", HttpStatus.NOT_FOUND);
		}
	}

}
