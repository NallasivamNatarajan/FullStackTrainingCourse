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
import com.cattle.management.converter.CattleTransferConverter;
import com.cattle.management.dto.CattleDTO;
import com.cattle.management.dto.CattleTransferDTO;
import com.cattle.management.entity.CattleTransfer;
import com.cattle.management.exception.TaskException;
import com.cattle.management.service.CattleService;
import com.cattle.management.service.CattleTransferService;

@RestController
@RequestMapping("/cattle")
public class CattleController {

	@Autowired
	private CattleService cattleService;
	
	@Autowired
	private CattleTransferService cattleTransferService;
	
	@Autowired
	private CattleTransferConverter cattleTransferConverter;
	
	@PostMapping(value="/cattle", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CattleDTO> addCattle(@Validated @RequestBody CattleDTO cattleDTO) throws TaskException{
		CattleTransfer cattleTransfer = cattleDTO.getTransfer();
		if(Objects.nonNull(cattleTransfer)) {
			CattleTransferDTO cattleTransferDTO = cattleTransferService.addCattleTransfer(cattleTransferConverter.entityToDto(cattleTransfer));
			cattleDTO.setTransfer(cattleTransferConverter.dtoToEntity(cattleTransferDTO));
		}
		CattleDTO cattleModel = cattleService.addCattle(cattleDTO);	
		HttpHeaders headers = new HttpHeaders();
		headers.add(CattleManagementConstants.CONTENT_TYPE, CattleManagementConstants.APPLICATION_TYPE);
		headers.add(CattleManagementConstants.ACCESS_ORIGIN, CattleManagementConstants.ALL);
		headers.add(CattleManagementConstants.ACCESS_HEADERS, CattleManagementConstants.HEADERS_TYPE);
		headers.add(CattleManagementConstants.ACCESS_HEADERS, CattleManagementConstants.POST);
        if (Objects.nonNull(cattleModel)) {
            ResponseEntity<CattleDTO> respEntity = new ResponseEntity<CattleDTO>(cattleModel,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<CattleDTO> respEntity = new ResponseEntity<CattleDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
	
    @GetMapping(value="/cattle/{cattleId}", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CattleDTO> getCattle(@PathVariable("cattleId") int cattleId) throws TaskException{
        CattleDTO cattleDTO = cattleService.getCattleById(cattleId);
        HttpHeaders headers = new HttpHeaders();
		headers.add(CattleManagementConstants.CONTENT_TYPE, CattleManagementConstants.APPLICATION_TYPE);
		headers.add(CattleManagementConstants.ACCESS_ORIGIN, CattleManagementConstants.ALL);
		headers.add(CattleManagementConstants.ACCESS_HEADERS, CattleManagementConstants.HEADERS_TYPE);
		headers.add(CattleManagementConstants.ACCESS_HEADERS, CattleManagementConstants.GET);
        if (Objects.nonNull(cattleDTO)) {
            ResponseEntity<CattleDTO> respEntity = new ResponseEntity<CattleDTO>(cattleDTO,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<CattleDTO> respEntity = new ResponseEntity<CattleDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
    
    @GetMapping(value="/cattles", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<CattleDTO>> getCattles() throws TaskException{
        Set<CattleDTO> cattleSet = cattleService.getAllCattle();
        HttpHeaders headers = new HttpHeaders();
        headers.add(CattleManagementConstants.CONTENT_TYPE, CattleManagementConstants.APPLICATION_TYPE);
		headers.add(CattleManagementConstants.ACCESS_ORIGIN, CattleManagementConstants.ALL);
		headers.add(CattleManagementConstants.ACCESS_HEADERS, CattleManagementConstants.HEADERS_TYPE);
		headers.add(CattleManagementConstants.ACCESS_HEADERS, CattleManagementConstants.GET);
        if (Objects.nonNull(cattleSet)) {
            ResponseEntity<Set<CattleDTO>> respEntity = new ResponseEntity<Set<CattleDTO>>(cattleSet,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<Set<CattleDTO>> respEntity = new ResponseEntity<Set<CattleDTO>>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
    
    @DeleteMapping(value="/cattle/{cattleId}")
    public ResponseEntity<String> deleteCattle(@PathVariable("cattleId")int cattleId) throws TaskException{
        HttpHeaders headers = new HttpHeaders();
        headers.add(CattleManagementConstants.CONTENT_TYPE, CattleManagementConstants.APPLICATION_TYPE);
		headers.add(CattleManagementConstants.ACCESS_ORIGIN, CattleManagementConstants.ALL);
		headers.add(CattleManagementConstants.ACCESS_HEADERS, CattleManagementConstants.HEADERS_TYPE);
		headers.add(CattleManagementConstants.ACCESS_HEADERS, CattleManagementConstants.DELETE);
        if (cattleService.deleteCattle(cattleId)) {
            ResponseEntity<String> respEntity = new ResponseEntity<String>(headers,HttpStatus.OK);
            return respEntity;
        }else {
            ResponseEntity<String> respEntity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
            return respEntity;
        }
    }
    
    @PutMapping(value="/cattle/{cattleId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CattleDTO> updateCattle(@PathVariable("cattleId") int cattleId, @Validated @RequestBody CattleDTO cattleDTO) throws TaskException{
    	CattleDTO cattleModel = cattleService.updateCattle(cattleDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add(CattleManagementConstants.CONTENT_TYPE, CattleManagementConstants.APPLICATION_TYPE);
		headers.add(CattleManagementConstants.ACCESS_ORIGIN, CattleManagementConstants.ALL);
		headers.add(CattleManagementConstants.ACCESS_HEADERS, CattleManagementConstants.HEADERS_TYPE);
		headers.add(CattleManagementConstants.ACCESS_HEADERS, CattleManagementConstants.PUT);
        if (Objects.nonNull(cattleModel)) {
            ResponseEntity<CattleDTO> respEntity = new ResponseEntity<CattleDTO>(cattleModel,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<CattleDTO> respEntity = new ResponseEntity<CattleDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
}