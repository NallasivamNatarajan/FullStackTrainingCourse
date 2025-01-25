package com.htc.event.management.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.htc.event.management.entity.Event;

public class StatusDTO {

	@NotNull
	private int statusId;
	
	private Event event;
	
	@NotBlank(message = "Status cannot be null")
	@Size(min = 3, max = 15, message = "Status should contain min 3 and max 15 characters")
	private String status;

	public StatusDTO() {
		super();
	}

	public StatusDTO(@NotNull int statusId, Event event,
			@NotBlank(message = "Status cannot be null") @Size(min = 3, max = 15, message = "Status should contain min 3 and max 15 characters") String status) {
		super();
		this.statusId = statusId;
		this.event = event;
		this.status = status;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "StatusDTO [statusId=" + statusId + ", status=" + status + "]";
	}
	
}
