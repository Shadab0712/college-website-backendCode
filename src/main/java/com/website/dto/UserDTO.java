package com.website.dto;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 2452018852019588406L;

	@NotBlank(message = "First name is mandatory")
	@Size(max = 50, message = "First name cannot exceed 50 characters")
	private String firstName;

	@NotBlank(message = "Last name is mandatory")
	@Size(max = 50, message = "Last name cannot exceed 50 characters")
	private String lastName;

	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email should be valid")
	private String email;

	@NotNull(message = "Mobile Number is mandatory")
    @Digits(integer = 10, fraction = 0, message = "Mobile number should have at most 10 digits")
	private Long mobileNumber;

	@NotBlank(message = "Address is mandatory")
	@Size(max = 50, message = "Address cannot exceed 50 characters")
	private String address;

	@NotBlank(message = "Message is mandatory")
	@Size(max = 500, message = "Message cannot exceed 500 characters")
	private String message;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
