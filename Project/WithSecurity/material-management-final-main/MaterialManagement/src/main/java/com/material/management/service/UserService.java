package com.material.management.service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.material.management.dto.UserDto;
import com.material.management.entity.Role;
import com.material.management.entity.User;
import com.material.management.repository.RoleRepository;
import com.material.management.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	public UserDto getUser(UserDto userDto) {
		UserDto userDtoRes = new UserDto();
		User user =userRepository.findByUserNamePassword(userDto.getUserName(),userDto.getPassword());
		if(Objects.nonNull(user)) {
			Role role = roleRepository.findById(user.getRoleId()).get();
			userDtoRes.setUserId(user.getUserId());
			userDtoRes.setUserName(user.getUsername());
			userDtoRes.setRoleId(role.getRoleId());
			userDtoRes.setDepartmentId(user.getDepartmentId());
			userDtoRes.setRoleName(role.getRoleName());
			return userDtoRes;
		}
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =userRepository.findByUserName(username);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),getAuthority(user));
	}
	
	private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getRoleName()));
        return authorities;
    }

}
