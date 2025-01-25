package com.htc.event.management.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.event.management.constants.EventManagementConstants;
import com.htc.event.management.converter.EventConverter;
import com.htc.event.management.dto.EventDTO;
import com.htc.event.management.dto.StatusDTO;
import com.htc.event.management.entity.Event;
import com.htc.event.management.exception.TaskException;
import com.htc.event.management.service.EventService;
import com.htc.event.management.service.StatusService;

@RestController
@RequestMapping("/status")
public class StatusController {
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private StatusService statusService;
	
	@Autowired
	private EventConverter eventConverter;
	
	@PostMapping(value="/status", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatusDTO> addStatus(@Validated @RequestBody StatusDTO statusDTO) throws TaskException{
		Event event = statusDTO.getEvent();
		EventDTO existingEventDTO = eventService.getEventById(event.getEventId());
		if(Objects.nonNull(event) && Objects.isNull(existingEventDTO)) {
			EventDTO eventDTO = eventService.addEvent(eventConverter.entityToDto(event));
			statusDTO.setEvent(eventConverter.dtoToEntity(eventDTO));
		}
		StatusDTO statusModel = statusService.addStatus(statusDTO);	
		HttpHeaders headers = new HttpHeaders();
		headers.add(EventManagementConstants.CONTENT_TYPE, EventManagementConstants.APPLICATION_TYPE);
		headers.add(EventManagementConstants.ACCESS_ORIGIN, EventManagementConstants.ALL);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.HEADERS_TYPE);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.POST);
        if (Objects.nonNull(statusModel)) {
            ResponseEntity<StatusDTO> respEntity = new ResponseEntity<StatusDTO>(statusModel,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<StatusDTO> respEntity = new ResponseEntity<StatusDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
	

}
