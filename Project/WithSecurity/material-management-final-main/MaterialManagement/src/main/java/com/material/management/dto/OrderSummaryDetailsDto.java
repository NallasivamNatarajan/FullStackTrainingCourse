package com.material.management.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;
@Data
public class OrderSummaryDetailsDto {
	
	private long orderId;
	private String orderNumber;
	private String lineNumber;
	private String orderType;
	private Date orderRequestedDate;
	private String requestSection;
	private String orderStatus;
	private String shiftInchargeComments;
	private String adminComments;
	private long userId;
	private String userName;
	private String departmentName;
	private List<CartDetailsDto> cartData;

}
