package com.cattle.management.controller;

import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cattle.management.dto.RoleDTO;
import com.cattle.management.exception.TaskException;
import com.cattle.management.service.RoleService;

@RestController
@RequestMapping("/cattleUserRole")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@PostMapping(value="/role", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleDTO> addRole(@Validated @RequestBody RoleDTO roleDTO) throws TaskException{
		RoleDTO roleModel = roleService.addRole(roleDTO);	
		HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
			headers.add("Access-Control-Allow-Origin", "*");
			headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
			headers.add("Access-Control-Allow-Headers", "Post");
        if (Objects.nonNull(roleModel)) {
            ResponseEntity<RoleDTO> respEntity = new ResponseEntity<RoleDTO>(roleModel,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<RoleDTO> respEntity = new ResponseEntity<RoleDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
	
    @GetMapping(value="/role/{roleId}", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleDTO> getRole(@PathVariable("roleId") int roleId) throws TaskException{
        RoleDTO roleDTO = roleService.getRoleById(roleId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
        headers.add("Access-Control-Allow-Headers", "GET");
        if (Objects.nonNull(roleDTO)) {
            ResponseEntity<RoleDTO> respEntity = new ResponseEntity<RoleDTO>(roleDTO,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<RoleDTO> respEntity = new ResponseEntity<RoleDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
    
    @GetMapping(value="/roles", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<RoleDTO>> getRoles() throws TaskException{
        Set<RoleDTO> roleSet = roleService.getAllRole();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
        headers.add("Access-Control-Allow-Headers", "GET");
        if (Objects.nonNull(roleSet)) {
            ResponseEntity<Set<RoleDTO>> respEntity = new ResponseEntity<Set<RoleDTO>>(roleSet,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<Set<RoleDTO>> respEntity = new ResponseEntity<Set<RoleDTO>>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
    
    @DeleteMapping(value="/role/{roleId}")
    public ResponseEntity<String> deleteRole(@PathVariable("roleId")int roleId) throws TaskException{
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
        headers.add("Access-Control-Allow-Headers", "DELETE");
        if (roleService.deleteRole(roleId)) {
            ResponseEntity<String> respEntity = new ResponseEntity<String>(headers,HttpStatus.OK);
            return respEntity;
        }else {
            ResponseEntity<String> respEntity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
            return respEntity;
        }
    }
    
    @PutMapping(value="/role/{roleId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleDTO> updateBook(@PathVariable("roleId") int roleId, @Validated @RequestBody RoleDTO roleDTO) throws TaskException{
    	RoleDTO roleModel = roleService.updateRole(roleDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
        headers.add("Access-Control-Allow-Headers", "PUT");
        if (Objects.nonNull(roleModel)) {
            ResponseEntity<RoleDTO> respEntity = new ResponseEntity<RoleDTO>(roleModel,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<RoleDTO> respEntity = new ResponseEntity<RoleDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
	
}
