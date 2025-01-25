package com.cattle.management.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.cattle.management.dto.RoleDTO;
import com.cattle.management.entity.Role;

@Component
public class RoleConverter {

	public Role dtoToEntity(RoleDTO roleDto) {
		Role role = new Role();
		BeanUtils.copyProperties(roleDto, role);
		return role;
	}

	public RoleDTO entityToDto(Role role) {
		RoleDTO roleDto = new RoleDTO();
		BeanUtils.copyProperties(role, roleDto);
		return roleDto;
	}
}
