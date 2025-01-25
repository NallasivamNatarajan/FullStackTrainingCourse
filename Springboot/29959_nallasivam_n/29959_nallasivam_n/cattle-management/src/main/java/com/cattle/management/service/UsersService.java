package com.cattle.management.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.cattle.management.converter.UsersConverter;
import com.cattle.management.dto.UsersDTO;
import com.cattle.management.entity.Users;
import com.cattle.management.exception.TaskException;
import com.cattle.management.repository.UsersRepository;

@Service("usersService")
public class UsersService {
	@Autowired
	UsersRepository usersRepository;

	@Autowired
	UsersConverter usersConverter;

	private static final Logger log = LoggerFactory.getLogger(UsersService.class);

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public UsersDTO addUsers(UsersDTO usersDto) throws TaskException {
		if (Objects.nonNull(usersDto)) {
			Users users = usersConverter.dtoToEntity(usersDto);
			Users newUsers;
			if (Objects.nonNull(users)) {
				newUsers = usersRepository.save(users);
				return usersConverter.entityToDto(newUsers);
			} else
				throw new TaskException("Users Data couldn't be inserted", HttpStatus.BAD_REQUEST);
		} else {
			throw new TaskException("Users Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public boolean deleteUsers(int usersId) throws TaskException {
		Optional<Users> usersOptional = usersRepository.findById(usersId);
		if (usersOptional.isPresent()) {
			usersRepository.deleteById(usersId);
			return true;
		} else {
			throw new TaskException("Users Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public UsersDTO getUsersById(int usersId) throws TaskException {
		Optional<Users> usersOptional = usersRepository.findById(usersId);
		if (usersOptional.isPresent())
			return usersConverter.entityToDto(usersOptional.get());
		else {
			throw new TaskException("Users Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public Set<UsersDTO> getAllUsers() throws TaskException {
		List<Users> usersList = (List<Users>) usersRepository.findAll();
		if (!CollectionUtils.isEmpty(usersList)) {
			return usersList.stream().map(users -> usersConverter.entityToDto(users)).collect(Collectors.toSet());
		} else {
			throw new TaskException("Users Infirmation not Found", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public UsersDTO updateUsers(UsersDTO usersDTO) throws TaskException {
		if (Objects.nonNull(usersDTO)) {
			Optional<Users> usersOptional = usersRepository.findById(usersDTO.getUserId());
			Users updatedUsers;
			if (usersOptional.isPresent()) {
				updatedUsers = usersConverter.dtoToEntity(usersDTO);
				return usersConverter.entityToDto(usersRepository.save(updatedUsers));
			}
			else {
				throw new TaskException("Users Data not Updated", HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new TaskException("Users Infirmation not Found", HttpStatus.NOT_FOUND);
		}
	}
}
