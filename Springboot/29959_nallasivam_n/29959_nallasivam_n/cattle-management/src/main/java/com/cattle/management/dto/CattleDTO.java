package com.cattle.management.dto;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cattle.management.entity.CattleTransfer;

public class CattleDTO {

	@NotNull
	private int cattleId;
	
	@NotNull(message = "Invalid Date Format")
	private Date birthDay;
	
	@NotNull
	private double birthWeight;
	
	@NotNull(message = "Invalid Date Format")
	private Date entranceDate;
	
	@NotBlank(message = "Operator cannot be null")
	@Size(min = 3, max = 6, message = "Operator should contain min 3 and max 6 characters")
	private String originalArea;
	private CattleTransfer transfer;
	
	@NotNull
	private boolean alive;

	public CattleDTO() {
		super();
	}

	public CattleDTO(@NotNull int cattleId, @NotNull(message = "Invalid Date Format") Date birthDay,
			@NotNull @Min(2) @Max(4) double birthWeight, @NotNull(message = "Invalid Date Format") Date entranceDate,
			@NotBlank(message = "Operator cannot be null") @Size(min = 3, max = 6, message = "Operator should contain min 3 and max 6 characters") String originalArea,
			CattleTransfer transfer, @NotNull boolean alive) {
		super();
		this.cattleId = cattleId;
		this.birthDay = birthDay;
		this.birthWeight = birthWeight;
		this.entranceDate = entranceDate;
		this.originalArea = originalArea;
		this.transfer = transfer;
		this.alive = alive;
	}

	public int getCattleId() {
		return cattleId;
	}

	public void setCattleId(int cattleId) {
		this.cattleId = cattleId;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public double getBirthWeight() {
		return birthWeight;
	}

	public void setBirthWeight(double birthWeight) {
		this.birthWeight = birthWeight;
	}

	public Date getEntranceDate() {
		return entranceDate;
	}

	public void setEntranceDate(Date entranceDate) {
		this.entranceDate = entranceDate;
	}

	public String getOriginalArea() {
		return originalArea;
	}

	public void setOriginalArea(String originalArea) {
		this.originalArea = originalArea;
	}

	public CattleTransfer getTransfer() {
		return transfer;
	}

	public void setTransfer(CattleTransfer transfer) {
		this.transfer = transfer;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	@Override
	public String toString() {
		return "CattleDTO [cattleId=" + cattleId + ", birthDay=" + birthDay + ", birthWeight=" + birthWeight
				+ ", entranceDate=" + entranceDate + ", originalArea=" + originalArea + ", transfer=" + transfer
				+ ", alive=" + alive + "]";
	}
}
