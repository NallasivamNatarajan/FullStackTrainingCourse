package com.cattle.management.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RoleDTO {
	@NotNull
	private int roleId;
	@NotBlank(message = "RoleName cannot be null")
	@Size(min = 3, max = 6, message = "RoleName should contain min 3 and max 6 characters")
	private String roleName;
	public RoleDTO() {
		super();
	}
	public RoleDTO(@NotNull int roleId,
			@NotBlank(message = "RoleName cannot be null") @Size(min = 3, max = 6, message = "RoleName should contain min 3 and max 6 characters") String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "RoleDTO [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
}
