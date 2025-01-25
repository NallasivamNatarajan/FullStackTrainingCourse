package com.material.management.dto;

import lombok.Data;

@Data
public class OrderCountsDto {
	private int pendingCount;
	private int approvedCount;
	private int rejectedCount;
	private int totalCount;
}
