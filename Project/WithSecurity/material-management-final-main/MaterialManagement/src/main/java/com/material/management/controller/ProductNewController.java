package com.material.management.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.material.management.dto.ProductMasterDto;
import com.material.management.service.ProductNewService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductNewController {
	
	static Logger log = LogManager.getLogger(ProductNewController.class);

	@Autowired
	ProductNewService productService;
	
	@GetMapping (value = "/getProducts",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductMasterDto>> getAllProducts()
	{
		List<ProductMasterDto> branchList = productService.getAllProducts();
		HttpHeaders headers = getHeaders("GET");
		
		if(branchList!=null)
		{		
			return new ResponseEntity<List<ProductMasterDto>> (branchList,headers,HttpStatus.OK);
		}
		return null;
	}
	@PostMapping("/addProduct")
	public ResponseEntity<ProductMasterDto> addBranch(@RequestBody ProductMasterDto productDto) {
		ProductMasterDto product = productService.addProduct(productDto);
		if (product != null) {
			log.info("Product Saved Success");
			ResponseEntity<ProductMasterDto> respEntity = new ResponseEntity<ProductMasterDto>(product, getHeaders("POST"),
					HttpStatus.CREATED);
			return respEntity;
		} else {
			log.error("Product Saved Fail");
			ResponseEntity<ProductMasterDto> respEntity = new ResponseEntity<ProductMasterDto>(HttpStatus.NOT_FOUND);
			return respEntity;
		}
	}

	private HttpHeaders getHeaders(String post) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Access-Control-Allow-Orgin", "*");
		headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With,Content-Type,Accept");
		headers.add("Access-Control-Allow-Methods", post);
		return headers;
	}
	
	@GetMapping(value="/getProduct/{productId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductMasterDto> getProduct(@PathVariable("productId") long productId){
		ProductMasterDto productMasterDTO = productService.getProductById(productId);
		HttpHeaders headers = getHeaders("GET");
		
		if(productMasterDTO!=null)
		{		
			return new ResponseEntity<ProductMasterDto> (productMasterDTO,headers,HttpStatus.OK);
		}
		return null;
	}
	@GetMapping("/hello")
	public String get(){
		return "Hello";
	}
}

