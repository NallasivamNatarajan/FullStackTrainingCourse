package com.htc.event.management.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.htc.event.management.dto.EventDTO;
import com.htc.event.management.entity.Event;

@Component
public class EventConverter {

	public Event dtoToEntity(EventDTO eventDto) {
		Event event = new Event();
		BeanUtils.copyProperties(eventDto, event);
		return event;
	}

	public EventDTO entityToDto(Event event) {
		EventDTO eventDto = new EventDTO();
		BeanUtils.copyProperties(event, eventDto);
		return eventDto;
	}
}
