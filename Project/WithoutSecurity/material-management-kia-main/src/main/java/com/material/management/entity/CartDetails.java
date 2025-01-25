package com.material.management.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="cartDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
	private long cartId;
	
	@Column(name = "product_id")
	private long productId;
	
	@Column(name = "order_id")
	private long orderId;
	
	@Column(name = "line_number")
	private String lineNumber;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "cart_status")
	private String cartStatus;
	
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "last_updated_by")
	private String lastUpdatedBy;
	@Column(name = "last_updated_date")
	private Date lastUpdatedDate;

}