package com.htc.hibernate.entity;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@SuppressWarnings("serial")
public class Cattle implements Serializable{
	
	private static long serialVersionUID = 1L;


	private int cattleId;
	private Date birthDay;
	private double birthWeight;
	private Date entranceDate;
	private String originalArea;
	private int cattleHouseId;
	private boolean flag;
	private int breedAreaId;
	private String immunityporty;

	public Cattle() {
		super();
	}

	public Cattle(int cattleId, Date birthDay, double birthWeight, Date entranceDate, String originalArea,
			int cattleHouseId, boolean flag, int breedAreaId, String immunityporty) {
		super();
		this.cattleId = cattleId;
		this.birthDay = birthDay;
		this.birthWeight = birthWeight;
		this.entranceDate = entranceDate;
		this.originalArea = originalArea;
		this.cattleHouseId = cattleHouseId;
		this.flag = flag;
		this.breedAreaId = breedAreaId;
		this.immunityporty = immunityporty;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		Cattle.serialVersionUID = serialVersionUID;
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

	public int getCattleHouseId() {
		return cattleHouseId;
	}

	public void setCattleHouseId(int cattleHouseId) {
		this.cattleHouseId = cattleHouseId;
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
	
	@Override
	public String toString() {
		return "Cattle [cattleId=" + cattleId + ", birthDay=" + birthDay + ", birthWeight=" + birthWeight
				+ ", entranceDate=" + entranceDate + ", originalArea=" + originalArea + ", cattleHouseId="
				+ cattleHouseId + ", flag=" + flag + ", breedAreaId=" + breedAreaId + ", immunityporty="
				+ immunityporty + "]";
	}

	public static Cattle fromDto(ResultSet resultSet) throws SQLException {
		Cattle cattle = new Cattle();
		cattle.setCattleId(resultSet.getInt(1));
		cattle.setBirthDay(resultSet.getDate(2));
		cattle.setBirthWeight(resultSet.getDouble(3));
		cattle.setEntranceDate(resultSet.getDate(4));
		cattle.setOriginalArea(resultSet.getString(5));
		cattle.setCattleHouseId(resultSet.getInt(6));
		cattle.setFlag(resultSet.getBoolean(7));
		cattle.setBreedAreaId(resultSet.getInt(8));
		cattle.setImmunityporty(resultSet.getString(9));
		return cattle;
	}

}
