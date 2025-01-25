package com.htc.event.management.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.htc.event.management.dto.StatusDTO;
import com.htc.event.management.entity.Status;

@Component
public class StatusConverter {

	public Status dtoToEntity(StatusDTO statusDto) {
		Status status = new Status();
		BeanUtils.copyProperties(statusDto, status);
		return status;
	}

	public StatusDTO entityToDto(Status status) {
		StatusDTO statusDto = new StatusDTO();
		BeanUtils.copyProperties(status, statusDto);
		return statusDto;
	}
}