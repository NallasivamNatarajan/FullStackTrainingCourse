package com.material.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInventoryDto {

	private long inventoryId;
	private long productId;
	private String lineNumber;
	private int quantity;
}
