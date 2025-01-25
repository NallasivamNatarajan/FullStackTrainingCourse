package com.cattle.management.controller;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cattle.management.converter.RoleConverter;
import com.cattle.management.dto.RoleDTO;
import com.cattle.management.dto.UsersDTO;
import com.cattle.management.entity.Role;
import com.cattle.management.exception.TaskException;
import com.cattle.management.service.RoleService;
import com.cattle.management.service.UsersService;

@RestController
@RequestMapping("/cattleEmployeeusers")
public class UsersController {

	@Autowired
	private UsersService usersService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private RoleConverter roleConverter;

	@PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsersDTO> addUsers(@Validated @RequestBody UsersDTO usersDTO) throws TaskException{
		Set<Role> roleSet = usersDTO.getRoles();
		Set<Role> newRoleSet = new HashSet<>();
		if (!CollectionUtils.isEmpty(roleSet)) {
			roleSet.stream().forEach(role -> {
				newRoleSet.add(addUserRole(roleConverter.entityToDto(role)));
			});
		}
		usersDTO.setRoles(newRoleSet);
		UsersDTO usersModel = usersService.addUsers(usersDTO);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
		headers.add("Access-Control-Allow-Headers", "Post");
		if (Objects.nonNull(usersModel)) {
			ResponseEntity<UsersDTO> respEntity = new ResponseEntity<UsersDTO>(usersModel, headers, HttpStatus.CREATED);
			return respEntity;
		} else {
			ResponseEntity<UsersDTO> respEntity = new ResponseEntity<UsersDTO>(HttpStatus.NOT_FOUND);
			return respEntity;
		}
	}

	@GetMapping(value = "/user/{usersId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsersDTO> getUsers(@PathVariable("userId") int userId) throws TaskException {
		UsersDTO usersDTO = usersService.getUsersById(userId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
		headers.add("Access-Control-Allow-Headers", "GET");
		if (Objects.nonNull(usersDTO)) {
			ResponseEntity<UsersDTO> respEntity = new ResponseEntity<UsersDTO>(usersDTO, headers, HttpStatus.CREATED);
			return respEntity;
		} else {
			ResponseEntity<UsersDTO> respEntity = new ResponseEntity<UsersDTO>(HttpStatus.NOT_FOUND);
			return respEntity;
		}
	}

	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<UsersDTO>> getUsers() throws TaskException {
		Set<UsersDTO> usersSet = usersService.getAllUsers();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
		headers.add("Access-Control-Allow-Headers", "GET");
		if (Objects.nonNull(usersSet)) {
			ResponseEntity<Set<UsersDTO>> respEntity = new ResponseEntity<Set<UsersDTO>>(usersSet, headers,
					HttpStatus.CREATED);
			return respEntity;
		} else {
			ResponseEntity<Set<UsersDTO>> respEntity = new ResponseEntity<Set<UsersDTO>>(HttpStatus.NOT_FOUND);
			return respEntity;
		}
	}

	@DeleteMapping(value = "/user/{usersId}")
	public ResponseEntity<String> deleteUsers(@PathVariable("usersId") int userId) throws TaskException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
		headers.add("Access-Control-Allow-Headers", "DELETE");
		if (usersService.deleteUsers(userId)) {
			ResponseEntity<String> respEntity = new ResponseEntity<String>(headers, HttpStatus.OK);
			return respEntity;
		} else {
			ResponseEntity<String> respEntity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			return respEntity;
		}
	}

	@PutMapping(value = "/users/{usersId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsersDTO> updateBook(@PathVariable("userId") int userId,
			@Validated @RequestBody UsersDTO usersDTO) throws TaskException {
		UsersDTO usersModel = usersService.updateUsers(usersDTO);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
		headers.add("Access-Control-Allow-Headers", "PUT");
		if (Objects.nonNull(usersModel)) {
			ResponseEntity<UsersDTO> respEntity = new ResponseEntity<UsersDTO>(usersModel, headers, HttpStatus.CREATED);
			return respEntity;
		} else {
			ResponseEntity<UsersDTO> respEntity = new ResponseEntity<UsersDTO>(HttpStatus.NOT_FOUND);
			return respEntity;
		}
	}

	private Role addUserRole(RoleDTO roleDTO) {
		try {
			return roleConverter.dtoToEntity(roleService.addRole(roleDTO));
		} catch (TaskException exception) {
		}
		return null;
	}

}
