package com.htc.spring.entity.relation.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_cattle")
public class Cattle {

	@Id
	@Column(name="cattle_id")
	private int cattleId;
	
	@Column(name="birth_day")
	@Temporal(TemporalType.DATE)
	private Date birthDay;
	
	@Column(name="birth_weight")
	private double birthWeight;
	
	@Column(name="entrance_date")
	@Temporal(TemporalType.DATE)
	private Date entranceDate;
	
	@Column(name="original_area")
	private String originalArea;
	
	@OneToOne
	@JoinColumn(name="cattle_house_id")
	private CattleHouse cattleHouse;
	
	@ManyToOne
	@JoinColumn(name="transfer_id")
	private CattleTransfer transfer;
	
	@Column(name="flag")
	private boolean flag;
	
	@Column(name="breed_area_id")
	private int breedAreaId;
	
	@Column(name="immunityporty")
	private String immunityporty;
	

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

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getBreedAreaId() {
		return breedAreaId;
	}

	public void setBreedAreaId(int breedAreaId) {
		this.breedAreaId = breedAreaId;
	}

	public String getImmunityporty() {
		return immunityporty;
	}

	public void setImmunityporty(String immunityporty) {
		this.immunityporty = immunityporty;
	}

	public CattleHouse getCattleHouse() {
		return cattleHouse;
	}

	public void setCattleHouse(CattleHouse cattleHouse) {
		this.cattleHouse = cattleHouse;
	}
	
	public Cattle(int cattleId, Date birthDay, double birthWeight, Date entranceDate, String originalArea,
			CattleHouse cattleHouse, CattleTransfer transfer, boolean flag, int breedAreaId, String immunityporty) {
		super();
		this.cattleId = cattleId;
		this.birthDay = birthDay;
		this.birthWeight = birthWeight;
		this.entranceDate = entranceDate;
		this.originalArea = originalArea;
		this.cattleHouse = cattleHouse;
		this.transfer = transfer;
		this.flag = flag;
		this.breedAreaId = breedAreaId;
		this.immunityporty = immunityporty;
	}

	@Override
	public String toString() {
		return "Cattle [cattleId=" + cattleId + ", birthDay=" + birthDay + ", birthWeight=" + birthWeight
				+ ", entranceDate=" + entranceDate + ", originalArea=" + originalArea + ", flag=" + flag + ", breedAreaId=" + breedAreaId + ", immunityporty="
				+ immunityporty + "]";
	}

	public Cattle() {
		super();
	}


}
