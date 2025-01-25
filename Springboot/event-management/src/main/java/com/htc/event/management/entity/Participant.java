package com.htc.event.management.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//i. Events Table(eventId(pk),eventname,location,contactPerson,contactNo,status).
//ii Event Status Table(statusId,eventId, status).
//iv. Registration Table( eventId,participantId)

@Entity
@Table(name="tb_participant")
public class Participant {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="participant_id")
	private int participantId;
	@Column(name="participant_name")
	private String participantName;
	@Column(name="mobile_no")
	private long mobileNo;
	@Column(name="email")
	private String email;
	@Column(name="address")
	private String address;
	public Participant() {
		super();
	}
	public Participant(int participantId, String participantName, long mobileNo, String email, String address) {
		super();
		this.participantId = participantId;
		this.participantName = participantName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.address = address;
	}
	public int getParticipantId() {
		return participantId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	public String getParticipantName() {
		return participantName;
	}
	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, email, mobileNo, participantId, participantName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participant other = (Participant) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& mobileNo == other.mobileNo && participantId == other.participantId
				&& Objects.equals(participantName, other.participantName);
	}
	@Override
	public String toString() {
		return "Participant [participantId=" + participantId + ", participantName=" + participantName + ", mobileNo="
				+ mobileNo + ", email=" + email + ", address=" + address + "]";
	}

}
