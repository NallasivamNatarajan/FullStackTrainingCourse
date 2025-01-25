package com.cattle.management.dto;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cattle.management.entity.CattleTransfer;
import com.cattle.management.entity.Users;

public class EmployeesDTO {
	
	@NotNull
	private int employeeId;

	private Set<Users> user;
	
	@NotBlank(message = "Operator cannot be null")
	@Size(min = 3, max = 6, message = "Operator should contain min 3 and max 6 characters")
	private String sex;
	
	@NotBlank(message = "Operator cannot be null")
	@Size(min = 3, max = 6, message = "Operator should contain min 3 and max 6 characters")
	private String department;
	
	@NotNull
	@Min(10)
	@Max(16)
	private long phone;
	
	@NotNull(message = "Invalid Date Format")
	private Date joinedDate;
	
	@NotBlank(message = "Operator cannot be null")
	@Size(min = 3, max = 60, message = "Operator should contain min 3 and max 6 characters")
	private String location;
	
	private CattleTransfer transfer;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Set<Users> getUser() {
		return user;
	}

	public void setUser(Set<Users> user) {
		this.user = user;
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

	public void setLocation(String location) {
		this.location = location;
	}

	public CattleTransfer getTransfer() {
		return transfer;
	}

	public void setTransfer(CattleTransfer transfer) {
		this.transfer = transfer;
	}

	public EmployeesDTO(@NotNull int employeeId, Set<Users> user,
			@NotBlank(message = "Operator cannot be null") @Size(min = 3, max = 6, message = "Operator should contain min 3 and max 6 characters") String sex,
			@NotBlank(message = "Operator cannot be null") @Size(min = 3, max = 6, message = "Operator should contain min 3 and max 6 characters") String department,
			@NotNull @Min(10) @Max(16) long phone, @NotNull(message = "Invalid Date Format") Date joinedDate,
			@NotBlank(message = "Operator cannot be null") @Size(min = 3, max = 60, message = "Operator should contain min 3 and max 6 characters") String location,
			CattleTransfer transfer) {
		super();
		this.employeeId = employeeId;
		this.user = user;
		this.sex = sex;
		this.department = department;
		this.phone = phone;
		this.joinedDate = joinedDate;
		this.location = location;
		this.transfer = transfer;
	}

	public EmployeesDTO() {
		super();
	}

	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", user=" + user + ", sex=" + sex + ", department="
				+ department + ", phone=" + phone + ", joinedDate=" + joinedDate + ", location=" + location
				+ ", transfer=" + transfer + "]";
	}

}
