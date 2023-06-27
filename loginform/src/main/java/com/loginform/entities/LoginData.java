package com.loginform.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginData {
	
	@NotBlank(message="User name can not be empty ")
	@Size(min=3,max=12,message="User Name must be between 3 - 12 characters ")
	private String userName;
	
	private String email;
	private boolean agreed;
 
	public LoginData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginData(String userName, String email) {
		super();
		this.userName = userName;
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAgreed() {
		return agreed;
	}

	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}

	
}
