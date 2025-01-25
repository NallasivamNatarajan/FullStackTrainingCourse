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

import com.cattle.management.converter.CattleTransferConverter;
import com.cattle.management.dto.CattleTransferDTO;
import com.cattle.management.dto.EmployeesDTO;
import com.cattle.management.entity.CattleTransfer;
import com.cattle.management.exception.TaskException;
import com.cattle.management.service.CattleTransferService;
import com.cattle.management.service.EmployeesService;

@RestController
@RequestMapping("/cattleEmployee")
public class EmployeesController {

	@Autowired
	private EmployeesService employeeService;
	
	@Autowired
	private CattleTransferService cattleTransferService;
	
	@Autowired
	private CattleTransferConverter cattleTransferConverter;
	
	@PostMapping(value="/employee", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeesDTO> addEmployees(@Validated @RequestBody EmployeesDTO employeeDTO) throws TaskException{
		CattleTransfer cattleTransfer = employeeDTO.getTransfer();
		if(Objects.nonNull(cattleTransfer)) {
			CattleTransferDTO cattleTransferDTO = cattleTransferService.addCattleTransfer(cattleTransferConverter.entityToDto(cattleTransfer));
			employeeDTO.setTransfer(cattleTransferConverter.dtoToEntity(cattleTransferDTO));
		}
		EmployeesDTO employeeModel = employeeService.addEmployees(employeeDTO);	
		HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
			headers.add("Access-Control-Allow-Origin", "*");
			headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
			headers.add("Access-Control-Allow-Headers", "Post");
        if (Objects.nonNull(employeeModel)) {
            ResponseEntity<EmployeesDTO> respEntity = new ResponseEntity<EmployeesDTO>(employeeModel,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<EmployeesDTO> respEntity = new ResponseEntity<EmployeesDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
	
    @GetMapping(value="/employee/{employeeId}", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeesDTO> getEmployees(@PathVariable("employeeId") int employeeId) throws TaskException{
        EmployeesDTO employeeDTO = employeeService.getEmployeesById(employeeId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
        headers.add("Access-Control-Allow-Headers", "GET");
        if (Objects.nonNull(employeeDTO)) {
            ResponseEntity<EmployeesDTO> respEntity = new ResponseEntity<EmployeesDTO>(employeeDTO,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<EmployeesDTO> respEntity = new ResponseEntity<EmployeesDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
    
    @GetMapping(value="/employees", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<EmployeesDTO>> getEmployeess() throws TaskException{
        Set<EmployeesDTO> employeeSet = employeeService.getAllEmployees();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
        headers.add("Access-Control-Allow-Headers", "GET");
        if (Objects.nonNull(employeeSet)) {
            ResponseEntity<Set<EmployeesDTO>> respEntity = new ResponseEntity<Set<EmployeesDTO>>(employeeSet,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<Set<EmployeesDTO>> respEntity = new ResponseEntity<Set<EmployeesDTO>>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
    
    @DeleteMapping(value="/employee/{employeeId}")
    public ResponseEntity<String> deleteEmployees(@PathVariable("employeeId")int employeeId) throws TaskException{
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
        headers.add("Access-Control-Allow-Headers", "DELETE");
        if (employeeService.deleteEmployees(employeeId)) {
            ResponseEntity<String> respEntity = new ResponseEntity<String>(headers,HttpStatus.OK);
            return respEntity;
        }else {
            ResponseEntity<String> respEntity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
            return respEntity;
        }
    }
    
    @PutMapping(value="/employee/{employeeId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeesDTO> updateEmployees(@PathVariable("employeeId") int employeeId, @Validated @RequestBody EmployeesDTO employeeDTO) throws TaskException{
    	EmployeesDTO employeeModel = employeeService.updateEmployees(employeeDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
        headers.add("Access-Control-Allow-Headers", "PUT");
        if (Objects.nonNull(employeeModel)) {
            ResponseEntity<EmployeesDTO> respEntity = new ResponseEntity<EmployeesDTO>(employeeModel,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<EmployeesDTO> respEntity = new ResponseEntity<EmployeesDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
}