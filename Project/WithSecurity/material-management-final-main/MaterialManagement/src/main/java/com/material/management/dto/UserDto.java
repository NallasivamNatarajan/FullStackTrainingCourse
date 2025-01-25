package com.material.management.dto;

import lombok.Data;

@Data
public class UserDto {
	
	private long userId;
	private String userName;
	private String password;
	private long roleId;
	private long departmentId;
	private String roleName;
	private String jwtToken;

}
