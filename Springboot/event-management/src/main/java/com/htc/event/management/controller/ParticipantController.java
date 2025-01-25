package com.htc.event.management.controller;

import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.event.management.constants.EventManagementConstants;
import com.htc.event.management.dto.ParticipantDTO;
import com.htc.event.management.exception.TaskException;
import com.htc.event.management.service.ParticipantService;

@RestController
@RequestMapping("/participant")
public class ParticipantController {

	@Autowired
	private ParticipantService participantService;
	
	private static final String PARTICIPANT_ID = "participantId";
	
	@PostMapping(value="/participant", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ParticipantDTO> addParticipant(@Validated @RequestBody ParticipantDTO participantDTO) throws TaskException{
		ParticipantDTO participantModel = participantService.addParticipant(participantDTO);	
		HttpHeaders headers = new HttpHeaders();
		headers.add(EventManagementConstants.CONTENT_TYPE, EventManagementConstants.APPLICATION_TYPE);
		headers.add(EventManagementConstants.ACCESS_ORIGIN, EventManagementConstants.ALL);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.HEADERS_TYPE);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.POST);
        if (Objects.nonNull(participantModel)) {
            ResponseEntity<ParticipantDTO> respEntity = new ResponseEntity<ParticipantDTO>(participantModel,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<ParticipantDTO> respEntity = new ResponseEntity<ParticipantDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
	
    @GetMapping(value="/participant/{participantId}", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ParticipantDTO> getParticipant(@PathVariable(PARTICIPANT_ID) int participantId) throws TaskException{
        ParticipantDTO participantDTO = participantService.getParticipantById(participantId);
        HttpHeaders headers = new HttpHeaders();
        headers.add(EventManagementConstants.CONTENT_TYPE, EventManagementConstants.APPLICATION_TYPE);
		headers.add(EventManagementConstants.ACCESS_ORIGIN, EventManagementConstants.ALL);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.HEADERS_TYPE);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.GET);
        if (Objects.nonNull(participantDTO)) {
            ResponseEntity<ParticipantDTO> respEntity = new ResponseEntity<ParticipantDTO>(participantDTO,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<ParticipantDTO> respEntity = new ResponseEntity<ParticipantDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
    
    @GetMapping(value="/participants", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<ParticipantDTO>> getParticipants() throws TaskException{
        Set<ParticipantDTO> participantSet = participantService.getAllParticipant();
        HttpHeaders headers = new HttpHeaders();
        headers.add(EventManagementConstants.CONTENT_TYPE, EventManagementConstants.APPLICATION_TYPE);
		headers.add(EventManagementConstants.ACCESS_ORIGIN, EventManagementConstants.ALL);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.HEADERS_TYPE);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.GET);
        if (Objects.nonNull(participantSet)) {
            ResponseEntity<Set<ParticipantDTO>> respEntity = new ResponseEntity<Set<ParticipantDTO>>(participantSet,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<Set<ParticipantDTO>> respEntity = new ResponseEntity<Set<ParticipantDTO>>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
    
    @DeleteMapping(value="/participant/{participantId}")
    public ResponseEntity<String> deleteParticipant(@PathVariable(PARTICIPANT_ID)int participantId) throws TaskException{
        HttpHeaders headers = new HttpHeaders();
        headers.add(EventManagementConstants.CONTENT_TYPE, EventManagementConstants.APPLICATION_TYPE);
		headers.add(EventManagementConstants.ACCESS_ORIGIN, EventManagementConstants.ALL);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.HEADERS_TYPE);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.DELETE);
        if (participantService.deleteParticipant(participantId)) {
            ResponseEntity<String> respEntity = new ResponseEntity<String>(headers,HttpStatus.OK);
            return respEntity;
        }else {
            ResponseEntity<String> respEntity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
            return respEntity;
        }
    }
    
    @PutMapping(value="/participant/{participantId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ParticipantDTO> updateBook(@PathVariable(PARTICIPANT_ID) int participantId, @Validated @RequestBody ParticipantDTO participantDTO) throws TaskException{
    	ParticipantDTO participantModel = participantService.updateParticipant(participantDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add(EventManagementConstants.CONTENT_TYPE, EventManagementConstants.APPLICATION_TYPE);
		headers.add(EventManagementConstants.ACCESS_ORIGIN, EventManagementConstants.ALL);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.HEADERS_TYPE);
		headers.add(EventManagementConstants.ACCESS_HEADERS, EventManagementConstants.PUT);
        if (Objects.nonNull(participantModel)) {
            ResponseEntity<ParticipantDTO> respEntity = new ResponseEntity<ParticipantDTO>(participantModel,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<ParticipantDTO> respEntity = new ResponseEntity<ParticipantDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
}
