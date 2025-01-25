package com.material.management.convertor;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.material.management.dto.UserDto;
import com.material.management.entity.User;

@Component
public class UserConverter {
	
	public User dtoToEntity(UserDto userDto) {
		User user=new User();
		BeanUtils.copyProperties(userDto, user);		
		return user;
	}
	
	public UserDto entityToDto(User user) {
		UserDto userDto=new UserDto();
		BeanUtils.copyProperties(user, userDto);
		return userDto;
	}

}
