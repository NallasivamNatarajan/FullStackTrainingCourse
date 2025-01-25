package com.htc.spring.entity.relation.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_employees")
public class Employees {
	
	@Id
	@Column(name="employee_id")
	private int employeeId;

	@ManyToOne
	@JoinColumn(name="user_id")
	private Users user;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="department")
	private String department;
	
	@Column(name="phone")
	private long phone;
	
	@Column(name="joined_date")
	private Date joinedDate;
	
	@Column(name="location")
	private String location;
	
	@ManyToOne
	@JoinColumn(name="transfer_id")
	private CattleTransfer transfer;

	public Employees() {
		super();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getLocation() {
		return location;
	}

	public Users getUser() {
		return user;
	}

	public void setUsers(Users users) {
		this.user = user;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Employees(int employeeId, Users user, String sex, String department, long phone, Date joinedDate,
			String location) {
		super();
		this.employeeId = employeeId;
		this.user = user;
		this.sex = sex;
		this.department = department;
		this.phone = phone;
		this.joinedDate = joinedDate;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", user=" + user + ", sex=" + sex + ", department=" + department
				+ ", phone=" + phone + ", joinedDate=" + joinedDate + ", location=" + location + "]";
	}
	
}
