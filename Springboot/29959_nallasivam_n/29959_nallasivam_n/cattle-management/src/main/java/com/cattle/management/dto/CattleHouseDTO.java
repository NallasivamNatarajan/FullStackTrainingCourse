package com.cattle.management.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CattleHouseDTO {
	@NotNull
	private int cattleHouseId;
	@NotBlank(message = "Cattle House Details cannot be null")
	@Size(min = 3, max = 6, message = "Cattle House Details should contain min 3 and max 6 characters")
	private String cattleHouseDetails;
	@NotBlank(message = "Capacity cannot be null")
	@Size(min = 3, max = 6, message = "Capacity should contain min 3 and max 6 characters")
	private String capacity;
	@NotBlank(message = "Operator cannot be null")
	@Size(min = 3, max = 6, message = "Operator should contain min 3 and max 6 characters")
	private String operator;
	@NotNull(message = "Invalid Date Format")
	private Date antisepsisDate;
	@NotBlank(message = "Record cannot be null")
	@Size(min = 3, max = 6, message = "Record should contain min 3 and max 6 characters")
	private String record;
	
	public int getCattleHouseId() {
		return cattleHouseId;
	}
	public void setCattleHouseId(int cattleHouseId) {
		this.cattleHouseId = cattleHouseId;
	}
	public String getCattleHouseDetails() {
		return cattleHouseDetails;
	}
	public void setCattleHouseDetails(String cattleHouseDetails) {
		this.cattleHouseDetails = cattleHouseDetails;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Date getAntisepsisDate() {
		return antisepsisDate;
	}
	public void setAntisepsisDate(Date antisepsisDate) {
		this.antisepsisDate = antisepsisDate;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public CattleHouseDTO() {
		super();
	}
	public CattleHouseDTO(@NotNull int cattleHouseId,
			@NotBlank(message = "Cattle House Details cannot be null") @Size(min = 3, max = 6, message = "Cattle House Details should contain min 3 and max 6 characters") String cattleHouseDetails,
			@NotBlank(message = "Capacity cannot be null") @Size(min = 3, max = 6, message = "Capacity should contain min 3 and max 6 characters") String capacity,
			@NotBlank(message = "Operator cannot be null") @Size(min = 3, max = 6, message = "Operator should contain min 3 and max 6 characters") String operator,
			@NotNull(message = "Invalid Date Format") Date antisepsisDate,
			@NotBlank(message = "Record cannot be null") @Size(min = 3, max = 6, message = "Record should contain min 3 and max 6 characters") String record) {
		super();
		this.cattleHouseId = cattleHouseId;
		this.cattleHouseDetails = cattleHouseDetails;
		this.capacity = capacity;
		this.operator = operator;
		this.antisepsisDate = antisepsisDate;
		this.record = record;
	}
}
