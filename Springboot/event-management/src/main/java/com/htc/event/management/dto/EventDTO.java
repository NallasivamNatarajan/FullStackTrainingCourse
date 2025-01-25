package com.htc.event.management.dto;

import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.htc.event.management.entity.Participant;
import com.htc.event.management.entity.Status;

public class EventDTO {
	
	@NotNull
	private int eventId;
	
	@NotBlank(message = "Event Name cannot be null")
	@Size(min = 3, max = 15, message = "Event Name should contain min 3 and max 15 characters")
	private String eventName;
	
	@NotBlank(message = "Location cannot be null")
	@Size(min = 5, max = 15, message = "Location should contain min 5 and max 15 characters")
	private String location;

	@NotBlank(message = "Contact Person cannot be null")
	@Size(min = 3, max = 15, message = "Contact Person should contain min 3 and max 15 characters")
	private String contactPerson;
	
	@NotNull
	@Min(10)
	private long contactNo;
	private Status status;
	private Set<Participant> participants;
	
	public EventDTO() {
		super();
	}

	public EventDTO(@NotNull int eventId,
			@NotBlank(message = "Event Name cannot be null") @Size(min = 3, max = 15, message = "Event Name should contain min 3 and max 15 characters") String eventName,
			@NotBlank(message = "Location cannot be null") @Size(min = 5, max = 15, message = "Location should contain min 5 and max 15 characters") String location,
			@NotBlank(message = "Contact Person cannot be null") @Size(min = 3, max = 15, message = "Contact Person should contain min 3 and max 15 characters") String contactPerson,
			@NotNull @Min(10) @Max(16) long contactNo, Status status, Set<Participant> participants) {
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
	public String toString() {
		return "EventDTO [eventId=" + eventId + ", eventName=" + eventName + ", location=" + location
				+ ", contactPerson=" + contactPerson + ", contactNo=" + contactNo + ", status=" + status + ", participants="
				+ participants + "]";
	}

}
