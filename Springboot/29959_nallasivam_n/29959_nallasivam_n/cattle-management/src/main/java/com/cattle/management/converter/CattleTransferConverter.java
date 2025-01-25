package com.cattle.management.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.cattle.management.dto.CattleTransferDTO;
import com.cattle.management.entity.CattleTransfer;

@Component
public class CattleTransferConverter {
	public CattleTransfer dtoToEntity(CattleTransferDTO roleDto) {
		CattleTransfer cattleTransfer = new CattleTransfer();
		BeanUtils.copyProperties(roleDto, cattleTransfer);
		return cattleTransfer;
	}

	public CattleTransferDTO entityToDto(CattleTransfer branch) {
		CattleTransferDTO cattleTransferDTO = new CattleTransferDTO();
		BeanUtils.copyProperties(branch, cattleTransferDTO);
		return cattleTransferDTO;
	}
}
