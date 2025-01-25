package com.cattle.management.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.cattle.management.dto.UsersDTO;
import com.cattle.management.entity.Users;

@Component
public class UsersConverter {

	public Users dtoToEntity(UsersDTO usersDto) {
		Users users = new Users();
		BeanUtils.copyProperties(usersDto, users);
		return users;
	}

	public UsersDTO entityToDto(Users users) {
		UsersDTO usersDto = new UsersDTO();
		BeanUtils.copyProperties(users, usersDto);
		return usersDto;
	}
}
