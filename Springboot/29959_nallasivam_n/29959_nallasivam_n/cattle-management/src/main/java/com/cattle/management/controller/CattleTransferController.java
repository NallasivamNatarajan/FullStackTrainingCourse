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

import com.cattle.management.converter.CattleHouseConverter;
import com.cattle.management.dto.CattleHouseDTO;
import com.cattle.management.dto.CattleTransferDTO;
import com.cattle.management.entity.CattleHouse;
import com.cattle.management.exception.TaskException;
import com.cattle.management.service.CattleHouseService;
import com.cattle.management.service.CattleTransferService;

@RestController
@RequestMapping("/cattleTransfer")
public class CattleTransferController {

	@Autowired
	private CattleTransferService cattleTransferService;
	
	@Autowired
	private CattleHouseService cattleHouseService;
	
	@Autowired
	private CattleHouseConverter cattleHouseConverter;
	
	@PostMapping(value="/cattleTransfer", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CattleTransferDTO> addCattleTransfer(@Validated @RequestBody CattleTransferDTO cattleTransferDTO) throws TaskException{
		CattleHouse cattleHouse = cattleTransferDTO.getCattleHouse();
		if(Objects.nonNull(cattleHouse)) {
			CattleHouseDTO cattleHouseDTO = cattleHouseService.addCattleHouse(cattleHouseConverter.entityToDto(cattleHouse));
			cattleTransferDTO.setCattleHouse(cattleHouseConverter.dtoToEntity(cattleHouseDTO));
		}
		CattleTransferDTO cattleTransferModel = cattleTransferService.addCattleTransfer(cattleTransferDTO);	
		HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
			headers.add("Access-Control-Allow-Origin", "*");
			headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
			headers.add("Access-Control-Allow-Headers", "Post");
        if (Objects.nonNull(cattleTransferModel)) {
            ResponseEntity<CattleTransferDTO> respEntity = new ResponseEntity<CattleTransferDTO>(cattleTransferModel,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<CattleTransferDTO> respEntity = new ResponseEntity<CattleTransferDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
	
    @GetMapping(value="/cattleTransfer/{cattleTransferId}", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CattleTransferDTO> getCattleTransfer(@PathVariable("cattleTransferId") int cattleTransferId) throws TaskException{
        CattleTransferDTO cattleTransferDTO = cattleTransferService.getCattleTransferById(cattleTransferId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
        headers.add("Access-Control-Allow-Headers", "GET");
        if (Objects.nonNull(cattleTransferDTO)) {
            ResponseEntity<CattleTransferDTO> respEntity = new ResponseEntity<CattleTransferDTO>(cattleTransferDTO,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<CattleTransferDTO> respEntity = new ResponseEntity<CattleTransferDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
    
    @GetMapping(value="/cattleTransfers", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<CattleTransferDTO>> getCattleTransfers() throws TaskException{
        Set<CattleTransferDTO> cattleTransferSet = cattleTransferService.getAllCattleTransfer();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
        headers.add("Access-Control-Allow-Headers", "GET");
        if (Objects.nonNull(cattleTransferSet)) {
            ResponseEntity<Set<CattleTransferDTO>> respEntity = new ResponseEntity<Set<CattleTransferDTO>>(cattleTransferSet,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<Set<CattleTransferDTO>> respEntity = new ResponseEntity<Set<CattleTransferDTO>>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
    
    @DeleteMapping(value="/cattleTransfer/{cattleTransferId}")
    public ResponseEntity<String> deleteCattleTransfer(@PathVariable("cattleTransferId")int cattleTransferId) throws TaskException{
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
        headers.add("Access-Control-Allow-Headers", "DELETE");
        if (cattleTransferService.deleteCattleTransfer(cattleTransferId)) {
            ResponseEntity<String> respEntity = new ResponseEntity<String>(headers,HttpStatus.OK);
            return respEntity;
        }else {
            ResponseEntity<String> respEntity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
            return respEntity;
        }
    }
    
    @PutMapping(value="/cattleTransfer/{cattleTransferId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CattleTransferDTO> updateCattleTransfer(@PathVariable("cattleTransferId") int cattleTransferId, @Validated @RequestBody CattleTransferDTO cattleTransferDTO) throws TaskException{
    	CattleTransferDTO cattleTransferModel = cattleTransferService.updateCattleTransfer(cattleTransferDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
        headers.add("Access-Control-Allow-Headers", "PUT");
        if (Objects.nonNull(cattleTransferModel)) {
            ResponseEntity<CattleTransferDTO> respEntity = new ResponseEntity<CattleTransferDTO>(cattleTransferModel,headers,HttpStatus.CREATED);
            return respEntity;
        }else {
            ResponseEntity<CattleTransferDTO> respEntity = new ResponseEntity<CattleTransferDTO>(HttpStatus.NOT_FOUND);
            return respEntity;
        }
    }
}