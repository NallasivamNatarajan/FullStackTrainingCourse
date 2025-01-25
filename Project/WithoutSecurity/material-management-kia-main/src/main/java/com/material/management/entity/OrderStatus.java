package com.material.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="orderStatus")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatus {
	
	@Id
	@Column(name = "order_status_id")
	private long orderStatusId;
	
	@Column(name = "order_status_name")
	private String orderStatusName;

}
