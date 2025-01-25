package com.material.management.util;

import java.util.Objects;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.material.management.repository.OrderDetailsRepository;

@Component
public class UtilsMethods {

	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	public static String getStingRandomNumber(String constant) {
		StringBuilder sb = new StringBuilder(constant);
		Random random = new Random();
		sb.append(String.valueOf(random.nextInt()).replaceAll("-", "0"));
		return sb.toString();
	}
	
	public  String generateNewOrderNumber() {
		int latestOrderId ;
		if(Objects.isNull(orderDetailsRepository.getLatestOrderId())) {
			latestOrderId = 1;
		}else {
			latestOrderId = orderDetailsRepository.getLatestOrderId() + 1;
		}
		String code = "RQ/2021/";
		String OrderNumber = code +String.format("%05d", latestOrderId);
		return OrderNumber;
	}
	

}
