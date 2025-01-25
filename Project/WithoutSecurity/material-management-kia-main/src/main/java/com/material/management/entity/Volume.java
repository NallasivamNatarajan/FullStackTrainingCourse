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
@Table(name ="volume")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Volume {
	
	@Id
	@Column(name = "volume_id")
	private long volumeId;
	
	@Column(name = "volume_meterics")
	private String volumeMeterics;

//	@OneToMany(mappedBy="volume")
//	Set<ProductMaster> productMaster;
}
