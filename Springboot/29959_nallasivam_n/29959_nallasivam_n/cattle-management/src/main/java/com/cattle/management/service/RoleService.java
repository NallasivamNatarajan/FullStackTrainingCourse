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

import com.cattle.management.converter.RoleConverter;
import com.cattle.management.dto.RoleDTO;
import com.cattle.management.entity.Role;
import com.cattle.management.exception.TaskException;
import com.cattle.management.repository.RoleRepository;

@Service("roleService")
public class RoleService {
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	RoleConverter roleConverter;

	private static final Logger log = LoggerFactory.getLogger(RoleService.class);

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public RoleDTO addRole(RoleDTO roleDto) throws TaskException {
		if (Objects.nonNull(roleDto)) {
			Role role = roleConverter.dtoToEntity(roleDto);
			Role newRole;
			if (Objects.nonNull(role)) {
				newRole = roleRepository.save(role);
				return roleConverter.entityToDto(newRole);
			} else
				throw new TaskException("Role Data couldn't be inserted", HttpStatus.BAD_REQUEST);
		} else {
			throw new TaskException("Role Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public boolean deleteRole(int roleId) throws TaskException {
		Optional<Role> roleOptional = roleRepository.findById(roleId);
		if (roleOptional.isPresent()) {
			roleRepository.deleteById(roleId);
			return true;
		} else {
			throw new TaskException("Role Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public RoleDTO getRoleById(int roleId) throws TaskException {
		Optional<Role> roleOptional = roleRepository.findById(roleId);
		if (roleOptional.isPresent())
			return roleConverter.entityToDto(roleOptional.get());
		else {
			throw new TaskException("Role Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public Set<RoleDTO> getAllRole() throws TaskException {
		List<Role> roleList = (List<Role>) roleRepository.findAll();
		if (!CollectionUtils.isEmpty(roleList)) {
			return roleList.stream().map(role -> roleConverter.entityToDto(role)).collect(Collectors.toSet());
		} else {
			throw new TaskException("Role Infirmation not Found", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public RoleDTO updateRole(RoleDTO roleDTO) throws TaskException {
		if (Objects.nonNull(roleDTO)) {
			Optional<Role> roleOptional = roleRepository.findById(roleDTO.getRoleId());
			Role updatedRole;
			if (roleOptional.isPresent()) {
				updatedRole = roleConverter.dtoToEntity(roleDTO);
				return roleConverter.entityToDto(roleRepository.save(updatedRole));
			}
			else {
				throw new TaskException("Role Data not Updated", HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new TaskException("Role Infirmation not Found", HttpStatus.NOT_FOUND);
		}
	}
}
