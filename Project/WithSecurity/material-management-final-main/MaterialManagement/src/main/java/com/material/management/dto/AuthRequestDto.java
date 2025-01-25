package com.material.management.dto;

public class AuthRequestDto {
	
	private String userName;
    private String password;
	public AuthRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthRequestDto(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AuthRequest [userName=" + userName + ", password=" + password + "]";
	}
    
    

}
