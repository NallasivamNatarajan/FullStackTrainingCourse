package com.htc.event.management.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ParticipantDTO {
	
	@NotNull
	private int participantId;
	
	@NotBlank(message = "Participant Name cannot be null")
	@Size(min = 3, max = 15, message = "Participant Name should contain min 3 and max 15 characters")
	private String participantName;
	
	@NotNull
	@Min(10)
	private long mobileNo;
	
	@NotBlank(message = "Email cannot be null")
	@Size(min = 7, max = 17, message = "Participant Email should contain min 7 and max 17 characters")
	private String email;
	
	@NotBlank(message = "Address cannot be null")
	@Size(min = 5, max = 25, message = "Address should contain min 5 and max 25 characters")
	private String address;

	public ParticipantDTO() {
		super();
	}

	public ParticipantDTO(@NotNull int participantId,
			@NotBlank(message = "Participant Name cannot be null") @Size(min = 3, max = 15, message = "Participant Name should contain min 3 and max 15 characters") String participantName,
			@NotNull @Min(10) @Max(16) long mobileNo,
			@NotBlank(message = "Email cannot be null") @Size(min = 7, max = 17, message = "Participant Email should contain min 7 and max 17 characters") String email,
			@NotBlank(message = "Address cannot be null") @Size(min = 5, max = 25, message = "Address should contain min 5 and max 25 characters") String address) {
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
	public String toString() {
		return "ParticipantDTO [participantId=" + participantId + ", participantName=" + participantName + ", mobileNo="
				+ mobileNo + ", email=" + email + ", address=" + address + "]";
	}

}
