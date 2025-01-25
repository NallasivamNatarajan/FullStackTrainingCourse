package com.material.management.dto;

import java.util.Date;

import lombok.Data;

@Data
public class OrderDetailsDto {
	
	private long orderId;
	private long cartId;
	private String orderNumber;
	private String lineNumber;
	private long userId;
	private String requestedDepartment;
	private String orderType;
	private String shiftInchargeComments;
	private String adminComments;
	private Date orderRequestedDate;
	private long orderStatusId;
	private String orderStatus;
	private String requestSection;
	private String createdBy;
	private Date createdDate;
	private String lastUpdatedBy;
	private Date lastUpdatedDate;
}
