package com.cattle.management.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cattle.management.entity.Employees;
import com.cattle.management.entity.Role;

public class UsersDTO {

	@NotNull
	private int userId;
	
	@NotBlank(message = "RoleName cannot be null")
	@Size(min = 3, max = 6, message = "RoleName should contain min 3 and max 6 characters")
	private String userName;
	
	@NotNull
	private String userPwd;
	private Employees employee;
	private Set<Role> roles;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public Employees getEmployee() {
		return employee;
	}
	public void setEmployee(Employees employee) {
		this.employee = employee;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public UsersDTO() {
		super();
	}
	public UsersDTO(@NotNull int userId,
			@NotBlank(message = "RoleName cannot be null") @Size(min = 3, max = 6, message = "RoleName should contain min 3 and max 6 characters") String userName,
			@NotNull String userPwd, Employees employee, Set<Role> roles) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.employee = employee;
		this.roles = roles;
	}

}
