package com.htc.event.management.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_event")
public class Event {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="event_id")
	private int eventId;
	@Column(name="event_name")
	private String eventName;
	@Column(name="location")
	private String location;
	@Column(name="contact_person")
	private String contactPerson;
	@Column(name="contact_no")
	private long contactNo;
	
	@OneToOne(mappedBy="event")
	private Status status;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
				name="tb_registration",
				joinColumns = @JoinColumn(name="event_id"),
				inverseJoinColumns = @JoinColumn(name="participant_id")		
			  )
	private Set<Participant> participants;

	public Event() {
		super();
	}

	public Event(int eventId, String eventName, String location, String contactPerson, long contactNo, Status status,
			Set<Participant> participants) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.location = location;
		this.contactPerson = contactPerson;
		this.contactNo = contactNo;
		this.status = status;
		this.participants = participants;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contactNo, contactPerson, eventId, eventName, location);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		return contactNo == other.contactNo && Objects.equals(contactPerson, other.contactPerson)
				&& eventId == other.eventId && Objects.equals(eventName, other.eventName)
				&& Objects.equals(location, other.location) && Objects.equals(participants, other.participants);
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", location=" + location + ", contactPerson="
				+ contactPerson + ", contactNo=" + contactNo + ", status=" + status + ", participants=" + participants + "]";
	}
	
}
