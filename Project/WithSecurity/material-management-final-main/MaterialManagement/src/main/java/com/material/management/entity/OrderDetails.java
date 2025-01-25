package com.material.management.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="orderDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private long orderId;
	
	@Column(name = "order_number")
	private String orderNumber;
	
	@Column(name = "line_number")
	private String lineNumber;
	
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "order_type")
	private String orderType;
	
	@Column(name = "shift_incharge_comments")
	private String shiftInchargeComments;
	
	@Column(name = "admin_comments")
	private String adminComments;
	
	@Column(name = "order_requested_date")
	private Date orderRequestedDate;
	
	@Column(name = "order_status_id")
	private long orderStatusId;
	
	@Column(name = "request_section")
	private String requestSection;
	
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "last_updated_by")
	private String lastUpdatedBy;
	@Column(name = "last_updated_date")
	private Date lastUpdatedDate;

}