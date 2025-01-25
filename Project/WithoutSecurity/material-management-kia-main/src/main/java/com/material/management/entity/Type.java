package com.material.management.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {
	
	@Id
	@Column(name = "type_id")
	private long typeId;
	
	@Column(name = "type_name")
	private String typeName;
	
//	@OneToMany(mappedBy="type")
//	Set<ProductMaster> productMaster;

}
