package com.material.management.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.material.management.dto.OrderDetailsDto;
import com.material.management.dto.OrderSummaryDetailsDto;
import com.material.management.service.MyOrdersService;

@RestController
@RequestMapping("/orderApproval")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderApprovalController {

static Logger log = LogManager.getLogger(MyOrdersController.class);
	
	@Autowired
	MyOrdersService myOrdersService;
	
	@PostMapping(value = "/updateOrder/{orderId}/{orderStatusId}/{comments}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateOrderDetails(@PathVariable("orderId") Long orderId,@PathVariable("orderStatusId") Long orderStatusId,@PathVariable String comments) {
		HttpHeaders headers = getHeaders("Post");
		String orderUpdateStatus = myOrdersService.updateOrderDetails(orderId,orderStatusId,comments);
		if (orderUpdateStatus != null) {
			log.info("OrderDetails Updated Successfully");
			return new ResponseEntity<String>(orderUpdateStatus, headers, HttpStatus.OK);
		} else {
			log.error("OrderDetails Not Found");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/OrderDetails",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrderDetailsDto>> getAllOrderDetails() {
		HttpHeaders headers = getHeaders("GET");
		List<OrderDetailsDto> orderDetails = myOrdersService.getAllOrderDetails();
		if (orderDetails != null) {
			log.info("OrderDetails Retrieved Successfully");
			return new ResponseEntity<List<OrderDetailsDto>>(orderDetails, headers, HttpStatus.OK);
		} else {
			log.error("OrderDetails Not Found");
			return new ResponseEntity<List<OrderDetailsDto>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/OrderDetails/{orderId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderSummaryDetailsDto> getOrderDetails(@PathVariable("orderId") Long orderId) {
		HttpHeaders headers = getHeaders("GET");
		OrderSummaryDetailsDto orderDetails = myOrdersService.getOrderDetails(orderId);
		if (orderDetails != null) {
			log.info("OrderDetails Retrieved Successfully");
			return new ResponseEntity<OrderSummaryDetailsDto>(orderDetails, headers, HttpStatus.OK);
		} else {
			log.error("OrderDetails Not Found");
			return new ResponseEntity<OrderSummaryDetailsDto>(HttpStatus.NOT_FOUND);
		}
	}
	
	private HttpHeaders getHeaders(String method) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Access-Control-Allow-Orgin", "*");
		headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With,Content-Type,Accept");
		headers.add("Access-Control-Allow-Methods", method);
		return headers;
	}
}
