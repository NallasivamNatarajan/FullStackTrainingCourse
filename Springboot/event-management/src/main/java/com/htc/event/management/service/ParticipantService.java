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

import com.htc.event.management.converter.ParticipantConverter;
import com.htc.event.management.dto.ParticipantDTO;
import com.htc.event.management.entity.Participant;
import com.htc.event.management.exception.TaskException;
import com.htc.event.management.repository.ParticipantRepository;

@Service("participantService")
public class ParticipantService {
	@Autowired
	ParticipantRepository participantRepository;

	@Autowired
	ParticipantConverter participantConverter;

	private static final Logger log = LoggerFactory.getLogger(ParticipantService.class);

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public ParticipantDTO addParticipant(ParticipantDTO participantDto) throws TaskException {
		if (Objects.nonNull(participantDto)) {
			Participant participant = participantConverter.dtoToEntity(participantDto);
			if (Objects.nonNull(participant)) {
				log.info("Participant added successfully");
				return participantConverter.entityToDto(participantRepository.save(participant));
			} else
				throw new TaskException("Participant Data couldn't be inserted", HttpStatus.BAD_REQUEST);
		} else {
			throw new TaskException("Participant Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public boolean deleteParticipant(int participantId) throws TaskException {
		Optional<Participant> participantOptional = participantRepository.findById(participantId);
		if (participantOptional.isPresent()) {
			log.info("Participant deleted successfully");
			participantRepository.deleteById(participantId);
			return true;
		} else {
			throw new TaskException("Participant Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public ParticipantDTO getParticipantById(int participantId) throws TaskException {
		Optional<Participant> participantOptional = participantRepository.findById(participantId);
		if (participantOptional.isPresent()) {
			log.info("Participant fetched successfully");
			return participantConverter.entityToDto(participantOptional.get());
		} else {
			throw new TaskException("Participant Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public Set<ParticipantDTO> getAllParticipant() throws TaskException {
		List<Participant> participantList = (List<Participant>) participantRepository.findAll();
		if (!CollectionUtils.isEmpty(participantList)) {
			return participantList.stream().map(participant -> participantConverter.entityToDto(participant))
					.collect(Collectors.toSet());
		} else {
			throw new TaskException("Participant Infirmation not Found", HttpStatus.NOT_FOUND);
		}
	}

	public ParticipantDTO updateParticipant(ParticipantDTO participantDTO) throws TaskException {
		if (Objects.nonNull(participantDTO)) {
			Optional<Participant> participantOptional = participantRepository
					.findById(participantDTO.getParticipantId());
			if (participantOptional.isPresent()) {
				log.info("Participant updated successfully");
				return participantConverter
						.entityToDto(participantRepository.save(participantConverter.dtoToEntity(participantDTO)));
			} else {
				throw new TaskException("Participant Data not Updated", HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new TaskException("Participant Infirmation not Found", HttpStatus.NOT_FOUND);
		}
	}
}
