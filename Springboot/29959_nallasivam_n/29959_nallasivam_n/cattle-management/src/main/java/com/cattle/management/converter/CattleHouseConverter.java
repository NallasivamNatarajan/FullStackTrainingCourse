package com.cattle.management.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.cattle.management.dto.CattleHouseDTO;
import com.cattle.management.entity.CattleHouse;

@Component
public class CattleHouseConverter {
	public CattleHouse dtoToEntity(CattleHouseDTO roleDto) {
		CattleHouse cattleHouse = new CattleHouse();
		BeanUtils.copyProperties(roleDto, cattleHouse);
		return cattleHouse;
	}

	public CattleHouseDTO entityToDto(CattleHouse branch) {
		CattleHouseDTO cattleHouseDTO = new CattleHouseDTO();
		BeanUtils.copyProperties(branch, cattleHouseDTO);
		return cattleHouseDTO;
	}
}
