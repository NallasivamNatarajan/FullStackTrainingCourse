package com.cattle.management.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.cattle.management.dto.CattleDTO;
import com.cattle.management.entity.Cattle;

@Component
public class CattleConverter {
	public Cattle dtoToEntity(CattleDTO roleDto) {
		Cattle cattle = new Cattle();
		BeanUtils.copyProperties(roleDto, cattle);
		return cattle;
	}

	public CattleDTO entityToDto(Cattle branch) {
		CattleDTO branchDto = new CattleDTO();
		BeanUtils.copyProperties(branch, branchDto);
		return branchDto;
	}
}
