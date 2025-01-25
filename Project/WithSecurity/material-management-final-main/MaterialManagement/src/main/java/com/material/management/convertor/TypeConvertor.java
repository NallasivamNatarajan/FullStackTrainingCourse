package com.material.management.convertor;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.material.management.dto.TypeDto;
import com.material.management.entity.Type;
@Component
public class TypeConvertor {
	public Type dtoToEntity(TypeDto typeDto) {
		Type type=new Type();
		BeanUtils.copyProperties(typeDto, type);		
		return type;
	}
	
	public TypeDto entityToDto(Type type) {
		TypeDto typeDto=new TypeDto();
		BeanUtils.copyProperties(type, typeDto);
		return typeDto;
		
	}
}
