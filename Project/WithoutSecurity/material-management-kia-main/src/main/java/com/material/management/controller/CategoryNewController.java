package com.material.management.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.material.management.entity.ProductRequest;
import com.material.management.service.CategoryNewService;
@RestController
@RequestMapping("/category")
public class CategoryNewController {
	static Logger log = LogManager.getLogger(CategoryNewController.class);

	@Autowired
	CategoryNewService categoryService;
	
	@GetMapping (value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductRequest> getAllCategory()
	{
		ProductRequest dropdownList = categoryService.getAllDropdownValues();
		HttpHeaders headers = getHeaders("GET");
		
		if(dropdownList!=null)
		{		
			return new ResponseEntity<ProductRequest> (dropdownList,headers,HttpStatus.OK);
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
