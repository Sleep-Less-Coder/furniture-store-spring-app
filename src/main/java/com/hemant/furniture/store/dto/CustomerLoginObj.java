package com.hemant.furniture.store.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class CustomerLoginObj {
	
	@NotNull
	@Size(min = 3, message = "Username cannot be empty and should be at least 3 characters.")
	private String username;
	
	@NotNull
	@Size(min = 1, message = "Password cannot be empty.")
	private String password;
	
	public CustomerLoginObj() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
