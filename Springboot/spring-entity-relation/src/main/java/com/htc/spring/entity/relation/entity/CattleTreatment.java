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
@Table(name="tb_cattle_treatment")
public class CattleTreatment {

	@Id
	@Column(name="treatment_id")
	private int treatmentId;

	@OneToOne
	@JoinColumn(name="cattle_id")
	private Cattle cattles;

	@Column(name="disease")
	private String disease;

	@ManyToOne
	@JoinColumn(name="curative_id")
	private Curative curative;
	
	@OneToOne
	@JoinColumn(name="employee_id")
	private Employees employees;
	
	@Column(name="operate_date")
	@Temporal(TemporalType.DATE)
	private Date operateDate;

	public CattleTreatment() {
		super();
	}

	public CattleTreatment(int treatmentId, String disease, Date operateDate) {
		super();
		this.treatmentId = treatmentId;
		this.disease = disease;
		this.operateDate = operateDate;
	}

	public int getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(int treatmentId) {
		this.treatmentId = treatmentId;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	@Override
	public String toString() {
		return "CattleTreatment [treatmentId=" + treatmentId + ", cattles=" + cattles + ", disease=" + disease
				+ ", curative=" + curative + ", employees=" + employees + ", operateDate=" + operateDate + "]";
	}
	
}
