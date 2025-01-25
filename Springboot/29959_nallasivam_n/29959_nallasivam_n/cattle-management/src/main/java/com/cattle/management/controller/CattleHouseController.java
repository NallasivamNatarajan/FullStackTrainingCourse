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

import com.cattle.management.constants.CattleManagementConstants;
import com.cattle.management.dto.CattleHouseDTO;
import com.cattle.management.exception.TaskException;
import com.cattle.management.service.CattleHouseService;

@RestController
@RequestMapping("/cattleHouse")
public class CattleHouseController {

	@Autowired
	private CattleHouseService cattleHouseService;
	
	@PostMapping(value="/cattleHouse", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CattleHouseDTO> addCattleHouse(@Validated @RequestBody CattleHouseDTO cattleHouseDTO) throws TaskException{
		CattleHouseDTO cattleHouseModel = cattleHouseService.addCattleHouse(cattleHouseDTO);	
		HttpHeaders headers = new HttpHeaders();
		headers.add(CattleManagementConstants.CONTENT_TYPE, CattleManagementConstants.APPLICATION_TYPE);
		headers.add(CattleManagementConstants.ACCESS_ORIGIN, CattleManagementConstants.ALL);
		headers.add(CattleManagementConstants.ACCESS_HEADERS, CattleManagementConstants.HEADERS_TYPE);
		headers.add(CattleManagementConstants.ACCESS_HEADERS, CattleManagementConstants.POST);
        if (Objects.nonNull(cattleHouseModel)) {
            ResponseEntity<CattleHouseDTO> respEntity = new ResponseEntity<CattleHouseDTO>(cattleHouseModel,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<CattleHouseDTO> respEntity = new ResponseEntity<CattleHouseDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
	
    @GetMapping(value="/cattleHouse/{cattleHouseId}", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CattleHouseDTO> getCattleHouse(@PathVariable("cattleHouseId") int cattleHouseId) throws TaskException{
        CattleHouseDTO cattleHouseDTO = cattleHouseService.getCattleHouseById(cattleHouseId);
        HttpHeaders headers = new HttpHeaders();
        headers.add(CattleManagementConstants.CONTENT_TYPE, CattleManagementConstants.APPLICATION_TYPE);
		headers.add(CattleManagementConstants.ACCESS_ORIGIN, CattleManagementConstants.ALL);
		headers.add(CattleManagementConstants.ACCESS_HEADERS, CattleManagementConstants.HEADERS_TYPE);
		headers.add(CattleManagementConstants.ACCESS_HEADERS, CattleManagementConstants.GET);
        if (Objects.nonNull(cattleHouseDTO)) {
            ResponseEntity<CattleHouseDTO> respEntity = new ResponseEntity<CattleHouseDTO>(cattleHouseDTO,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<CattleHouseDTO> respEntity = new ResponseEntity<CattleHouseDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
    
    @GetMapping(value="/cattleHouses", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<CattleHouseDTO>> getCattleHouses() throws TaskException{
        Set<CattleHouseDTO> cattleHouseSet = cattleHouseService.getAllCattleHouse();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
        headers.add("Access-Control-Allow-Headers", "GET");
        if (Objects.nonNull(cattleHouseSet)) {
            ResponseEntity<Set<CattleHouseDTO>> respEntity = new ResponseEntity<Set<CattleHouseDTO>>(cattleHouseSet,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<Set<CattleHouseDTO>> respEntity = new ResponseEntity<Set<CattleHouseDTO>>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
    
    @DeleteMapping(value="/cattleHouse/{cattleHouseId}")
    public ResponseEntity<String> deleteCattleHouse(@PathVariable("cattleHouseId")int cattleHouseId) throws TaskException{
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
        headers.add("Access-Control-Allow-Headers", "DELETE");
        if (cattleHouseService.deleteCattleHouse(cattleHouseId)) {
            ResponseEntity<String> respEntity = new ResponseEntity<String>(headers,HttpStatus.OK);
            return respEntity;
        }else {
            ResponseEntity<String> respEntity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
            return respEntity;
        }
    }
    
    @PutMapping(value="/cattleHouse/{cattleHouseId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CattleHouseDTO> updateBook(@PathVariable("cattleHouseId") int cattleHouseId, @Validated @RequestBody CattleHouseDTO cattleHouseDTO) throws TaskException{
    	CattleHouseDTO cattleHouseModel = cattleHouseService.updateCattleHouse(cattleHouseDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
        headers.add("Access-Control-Allow-Headers", "PUT");
        if (Objects.nonNull(cattleHouseModel)) {
            ResponseEntity<CattleHouseDTO> respEntity = new ResponseEntity<CattleHouseDTO>(cattleHouseModel,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<CattleHouseDTO> respEntity = new ResponseEntity<CattleHouseDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
}
