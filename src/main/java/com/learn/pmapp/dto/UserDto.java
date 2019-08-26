package com.learn.pmapp.dto;

import java.util.Date;

public class UserDto {
	

	private int userId;
	
	private String employeeId;
	
	private Date firstName;
	
	private Date lastName;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Date getFirstName() {
		return firstName;
	}

	public void setFirstName(Date firstName) {
		this.firstName = firstName;
	}

	public Date getLastName() {
		return lastName;
	}

	public void setLastName(Date lastName) {
		this.lastName = lastName;
	}

}
