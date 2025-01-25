package com.htc.spring.entity.relation.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_cattle_feed")
public class CattleFeed {

	@Id
	@Column(name="cattle_feed_id")
	private int cattleFeedId;
	
	@OneToOne
	@JoinColumn(name="cattle_id")
	private Cattle cattle;
	
	@ManyToOne
	@JoinColumn(name="feed_id")
	private Feeds feeds;
	
	@Column(name="feed_amount")
	private double feedAmount;
	
	@OneToOne
	@JoinColumn(name="employee_id")
	private Employees employees;
	
	@Column(name="operate_date")
	@Temporal(TemporalType.DATE)
	private Date operateDate;

	public CattleFeed() {
		super();
	}

	public CattleFeed(int cattleFeedId, double feedAmount, Date operateDate) {
		super();
		this.cattleFeedId = cattleFeedId;
		this.feedAmount = feedAmount;
		this.operateDate = operateDate;
	}

	public int getCattleFeedId() {
		return cattleFeedId;
	}

	public void setCattleFeedId(int cattleFeedId) {
		this.cattleFeedId = cattleFeedId;
	}

	public double getFeedAmount() {
		return feedAmount;
	}

	public void setFeedAmount(double feedAmount) {
		this.feedAmount = feedAmount;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	@Override
	public String toString() {
		return "CattleFeed [cattleFeedId=" + cattleFeedId + ", cattle=" + cattle + ", feeds=" + feeds + ", feedAmount="
				+ feedAmount + ", employees=" + employees + ", operateDate=" + operateDate + "]";
	}
	
}
