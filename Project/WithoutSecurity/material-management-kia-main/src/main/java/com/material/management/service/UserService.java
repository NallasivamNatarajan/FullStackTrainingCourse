package com.material.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.material.management.dto.UserDto;
import com.material.management.entity.Role;
import com.material.management.entity.User;
import com.material.management.repository.RoleRepository;
import com.material.management.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	public UserDto getUser(UserDto userDto) {
		UserDto userDtoRes = new UserDto();
		User user =userRepository.findByUserNamePassword(userDto.getUserName(),userDto.getPassword());
		Role role = roleRepository.findById(user.getRoleId()).get();
		userDtoRes.setUserId(user.getUserId());
		userDtoRes.setUserName(user.getUserName());
		userDtoRes.setRoleName(role.getRoleName());
		return userDtoRes;
	}

}
