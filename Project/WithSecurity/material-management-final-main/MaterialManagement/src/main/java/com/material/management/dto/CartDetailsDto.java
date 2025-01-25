package com.material.management.dto;

import com.material.management.entity.Category;
import com.material.management.entity.Type;

import lombok.Data;

@Data
public class CartDetailsDto {

	private long productId;
	//private long orderId;
	private String lineNumber;
	private int quantity;
//	private String cartStatus;
//	private String createdBy;
//	private Date createdDate;
//	private String lastUpdatedBy;
//	private Date lastUpdatedDate;
	private String productName;
	private Category category;
	private Type type;
	private int length;
	private int diameter;
	private int driveSize;

}
