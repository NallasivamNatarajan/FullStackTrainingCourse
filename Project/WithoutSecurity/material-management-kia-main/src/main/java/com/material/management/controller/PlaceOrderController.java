package com.material.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.material.management.dto.PlaceOrderCategoryDto;
import com.material.management.service.PlaceOrderService;

@RestController
@RequestMapping("/placeOrder")
@CrossOrigin(origins = "http://localhost:4200")
public class PlaceOrderController {

	@Autowired
	PlaceOrderService placeOrderService;

	@GetMapping(value = "/getAllDropdownList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PlaceOrderCategoryDto> getAllCategory() {
		PlaceOrderCategoryDto dropdownList = placeOrderService.getDropDownListDto();
		HttpHeaders headers = getHeaders("GET");

		if (dropdownList != null) {
			return new ResponseEntity<PlaceOrderCategoryDto>(dropdownList, headers, HttpStatus.OK);
		}
		return null;
	}

	private HttpHeaders getHeaders(String post) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Access-Control-Allow-Orgin", "*");
		headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With,Content-Type,Accept");
		headers.add("Access-Control-Allow-Methods", post);
		return headers;
	}

}
