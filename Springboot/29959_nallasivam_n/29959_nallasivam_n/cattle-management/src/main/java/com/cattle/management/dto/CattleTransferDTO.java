package com.cattle.management.dto;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cattle.management.entity.Cattle;
import com.cattle.management.entity.CattleHouse;
import com.cattle.management.entity.Employees;

public class CattleTransferDTO {
	@NotNull
	private int transferId;
	
	private Set<Cattle> cattles;
	
	@NotBlank(message = "Cattle House Details cannot be null")
	@Size(min = 3, max = 6, message = "Cattle House Details should contain min 3 and max 6 characters")
	private String cattleFrom;
	
	private CattleHouse cattleHouse;
	
	@NotBlank(message = "Cattle House Details cannot be null")
	@Size(min = 3, max = 6, message = "Cattle House Details should contain min 3 and max 6 characters")
	private String transferReason;
	
	private Set<Employees> employees;
	
	@NotNull(message = "Invalid Date Format")
	private Date operateDate;

	public CattleTransferDTO() {
		super();
	}

	public CattleTransferDTO(@NotNull int transferId,
			@NotBlank(message = "Cattle House Details cannot be null") @Size(min = 3, max = 6, message = "Cattle House Details should contain min 3 and max 6 characters") String cattleFrom,
			@NotBlank(message = "Cattle House Details cannot be null") @Size(min = 3, max = 6, message = "Cattle House Details should contain min 3 and max 6 characters") String transferReason,
			@NotNull(message = "Invalid Date Format") Date operateDate) {
		super();
		this.transferId = transferId;
		this.cattleFrom = cattleFrom;
		this.transferReason = transferReason;
		this.operateDate = operateDate;
	}

	public int getTransferId() {
		return transferId;
	}

	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}

	public Set<Cattle> getCattles() {
		return cattles;
	}

	public void setCattles(Set<Cattle> cattles) {
		this.cattles = cattles;
	}

	public String getCattleFrom() {
		return cattleFrom;
	}

	public void setCattleFrom(String cattleFrom) {
		this.cattleFrom = cattleFrom;
	}

	public CattleHouse getCattleHouse() {
		return cattleHouse;
	}

	public void setCattleHouse(CattleHouse cattleHouse) {
		this.cattleHouse = cattleHouse;
	}

	public String getTransferReason() {
		return transferReason;
	}

	public void setTransferReason(String transferReason) {
		this.transferReason = transferReason;
	}

	public Set<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employees> employees) {
		this.employees = employees;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	@Override
	public String toString() {
		return "CattleTransferDTO [transferId=" + transferId + ", cattles=" + cattles + ", cattleFrom=" + cattleFrom
				+ ", cattleHouse=" + cattleHouse + ", transferReason=" + transferReason + ", employees=" + employees
				+ ", operateDate=" + operateDate + "]";
	}
}
