package com.htc.event.management.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.htc.event.management.dto.ParticipantDTO;
import com.htc.event.management.entity.Participant;

@Component
public class ParticipantConverter {

	public Participant dtoToEntity(ParticipantDTO participantDto) {
		Participant participant = new Participant();
		BeanUtils.copyProperties(participantDto, participant);
		return participant;
	}

	public ParticipantDTO entityToDto(Participant participant) {
		ParticipantDTO participantDto = new ParticipantDTO();
		BeanUtils.copyProperties(participant, participantDto);
		return participantDto;
	}
}
