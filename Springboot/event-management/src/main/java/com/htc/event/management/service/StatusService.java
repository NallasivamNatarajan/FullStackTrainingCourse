package com.htc.event.management.service;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.htc.event.management.converter.StatusConverter;
import com.htc.event.management.dto.StatusDTO;
import com.htc.event.management.entity.Status;
import com.htc.event.management.exception.TaskException;
import com.htc.event.management.repository.StatusRepository;

@Service("statusService")
public class StatusService {

	@Autowired
	StatusRepository statusRepository;

	@Autowired
	StatusConverter statusConverter;

	private static final Logger log = LoggerFactory.getLogger(StatusService.class);

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public StatusDTO addStatus(StatusDTO statusDTO) throws TaskException {
		if (Objects.nonNull(statusDTO)) {
			Status status = statusConverter.dtoToEntity(statusDTO);
			if (Objects.nonNull(status)) {
				log.info("Status of the Event added successfully");
				return statusConverter.entityToDto(statusRepository.save(status));
			} else
				throw new TaskException("Status Info couldn't be inserted", HttpStatus.BAD_REQUEST);
		} else {
			throw new TaskException("Status Info not valid", HttpStatus.NOT_FOUND);
		}
	}

}
