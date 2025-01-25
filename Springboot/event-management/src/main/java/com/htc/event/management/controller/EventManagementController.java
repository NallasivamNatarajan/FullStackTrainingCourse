package com.htc.event.management.controller;

import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.event.management.constants.EventManagementConstants;
import com.htc.event.management.converter.ParticipantConverter;
import com.htc.event.management.dto.EventDTO;
import com.htc.event.management.entity.Participant;
import com.htc.event.management.exception.TaskException;
import com.htc.event.management.service.EventService;
import com.htc.event.management.service.ParticipantService;

@RestController
@RequestMapping("/event")
public class EventManagementController {

	@Autowired
	private EventService eventService;
	
	@Autowired
	private ParticipantService participantService;
	
	@Autowired
	private ParticipantConverter participantConverter;
	
	private static final String EVENT_ID = "eventId";
	
	@PostMapping(value="/event", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EventDTO> addEvent(@Validated @RequestBody EventDTO eventDTO) throws TaskException{
		EventDTO eventModel = eventService.addEvent(eventDTO);	
		HttpHeaders headers = new HttpHeaders();
		headers.add(EventManagementConstants.CONTENT_TYPE, EventManagementConstants.APPLICATION_TYPE);
		headers.add(EventManagementConstants.ACCESS_ORIGIN, EventManagementConstants.ALL);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.HEADERS_TYPE);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.POST);
        if (Objects.nonNull(eventModel)) {
            ResponseEntity<EventDTO> respEntity = new ResponseEntity<EventDTO>(eventModel,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<EventDTO> respEntity = new ResponseEntity<EventDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
	
	@PostMapping(value="/eventRegistration", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EventDTO> addEventRegistration(@Validated @RequestBody EventDTO eventDTO) throws TaskException{
		
		Set<Participant> participantSet = eventDTO.getParticipants();
		if(!CollectionUtils.isEmpty(participantSet)) {
			addEventParticipants(participantSet);
		}
		EventDTO eventModel = eventService.addEvent(eventDTO);	
		HttpHeaders headers = new HttpHeaders();
		headers.add(EventManagementConstants.CONTENT_TYPE, EventManagementConstants.APPLICATION_TYPE);
		headers.add(EventManagementConstants.ACCESS_ORIGIN, EventManagementConstants.ALL);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.HEADERS_TYPE);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.POST);
        if (Objects.nonNull(eventModel)) {
            ResponseEntity<EventDTO> respEntity = new ResponseEntity<EventDTO>(eventModel,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<EventDTO> respEntity = new ResponseEntity<EventDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
	
    private void addEventParticipants(Set<Participant> participantSet) {
    	participantSet.stream().forEach(participant -> {
			try {
				participantService.addParticipant(participantConverter.entityToDto(participant));
			} catch (TaskException exception) {
				exception.getMessage();
			}
		});
	}

	@GetMapping(value="/event/{eventId}", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EventDTO> getEvent(@PathVariable(EVENT_ID) int eventId) throws TaskException{
        EventDTO eventDTO = eventService.getEventById(eventId);
        HttpHeaders headers = new HttpHeaders();
        headers.add(EventManagementConstants.CONTENT_TYPE, EventManagementConstants.APPLICATION_TYPE);
		headers.add(EventManagementConstants.ACCESS_ORIGIN, EventManagementConstants.ALL);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.HEADERS_TYPE);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.GET);
        if (Objects.nonNull(eventDTO)) {
            ResponseEntity<EventDTO> respEntity = new ResponseEntity<EventDTO>(eventDTO,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<EventDTO> respEntity = new ResponseEntity<EventDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
    
    @GetMapping(value="/events", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<EventDTO>> getEvents() throws TaskException{
        Set<EventDTO> eventSet = eventService.getAllEvent();
        HttpHeaders headers = new HttpHeaders();
        headers.add(EventManagementConstants.CONTENT_TYPE, EventManagementConstants.APPLICATION_TYPE);
		headers.add(EventManagementConstants.ACCESS_ORIGIN, EventManagementConstants.ALL);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.HEADERS_TYPE);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.GET);
        if (Objects.nonNull(eventSet)) {
            ResponseEntity<Set<EventDTO>> respEntity = new ResponseEntity<Set<EventDTO>>(eventSet,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<Set<EventDTO>> respEntity = new ResponseEntity<Set<EventDTO>>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
    
    
    @GetMapping(value="/eventParticipants/{eventId}", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EventDTO> getEventParticipants(@PathVariable(EVENT_ID) int eventId) throws TaskException{
        EventDTO eventDTO = eventService.getEventById(eventId);
        HttpHeaders headers = new HttpHeaders();
        headers.add(EventManagementConstants.CONTENT_TYPE, EventManagementConstants.APPLICATION_TYPE);
		headers.add(EventManagementConstants.ACCESS_ORIGIN, EventManagementConstants.ALL);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.HEADERS_TYPE);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.GET);
        if (Objects.nonNull(eventDTO)) {
            ResponseEntity<EventDTO> respEntity = new ResponseEntity<EventDTO>(eventDTO,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<EventDTO> respEntity = new ResponseEntity<EventDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
    
    
    @GetMapping(value="/eventsReport", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<EventDTO>> getEventsReport() throws TaskException{
        Set<EventDTO> eventSet = eventService.getEventsReport();
        HttpHeaders headers = new HttpHeaders();
        headers.add(EventManagementConstants.CONTENT_TYPE, EventManagementConstants.APPLICATION_TYPE);
		headers.add(EventManagementConstants.ACCESS_ORIGIN, EventManagementConstants.ALL);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.HEADERS_TYPE);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.GET);
        if (Objects.nonNull(eventSet)) {
            ResponseEntity<Set<EventDTO>> respEntity = new ResponseEntity<Set<EventDTO>>(eventSet,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<Set<EventDTO>> respEntity = new ResponseEntity<Set<EventDTO>>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
    
    
}

