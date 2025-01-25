package com.material.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	
	@Id
	@Column(name = "role_id")
	private long roleId;
	
	@Column(name = "role_name")
	private String roleName;

}
