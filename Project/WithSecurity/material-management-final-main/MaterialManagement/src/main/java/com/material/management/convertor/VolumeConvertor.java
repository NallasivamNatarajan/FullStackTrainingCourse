package com.material.management.convertor;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.material.management.dto.VolumeDto;
import com.material.management.entity.Volume;
@Component
public class VolumeConvertor {
	public Volume dtoToEntity(VolumeDto volumeDto) {
		Volume volume=new Volume();
		BeanUtils.copyProperties(volumeDto, volume);		
		return volume;
	}
	
	public VolumeDto entityToDto(Volume volume) {
		VolumeDto volumeDto=new VolumeDto();
		BeanUtils.copyProperties(volume, volumeDto);
		return volumeDto;
		
	}

}
